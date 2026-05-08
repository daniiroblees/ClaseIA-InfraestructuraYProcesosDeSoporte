# GitHub Actions CI Pipeline

This document describes the continuous integration (CI) pipeline implemented for the MathUtils project using GitHub Actions.

## Overview

The CI pipeline provides automated testing, code quality analysis, and security scanning across multiple platforms and Java versions.

## Workflow Structure

### Triggers

The CI pipeline runs on:
- **Push** to `main` or `develop` branches
- **Pull requests** to `main` or `develop` branches

### Jobs

#### 1. Test Matrix (`test`)

**Purpose**: Execute tests across multiple environments

**Matrix Configuration**:
- **OS**: `ubuntu-latest`, `windows-latest`, `macos-latest`
- **Java**: `8`, `11`, `17`, `21`
- **Exclusions**: Windows + Java 8 (problematic combination)

**Steps**:
1. Checkout code with full history
2. Set up JDK with Maven caching
3. Validate Maven wrapper
4. Compile code
5. Run tests
6. Upload test results as artifacts

#### 2. Code Quality (`code-quality`)

**Purpose**: Analyze code quality and generate coverage reports

**Conditions**: Runs after tests, only on main branch or PRs to main

**Steps**:
1. Checkout code
2. Set up JDK 17
3. Run tests with JaCoCo coverage
4. Run Checkstyle analysis
5. Run PMD static analysis
6. Upload coverage to Codecov (optional)

#### 3. Security (`security`)

**Purpose**: Scan for security vulnerabilities

**Conditions**: Runs after tests, only on main branch or PRs to main

**Steps**:
1. Checkout code
2. Set up JDK 17
3. Run OWASP Dependency Check
4. Upload security reports

#### 4. Build Summary (`build-summary`)

**Purpose**: Provide comprehensive build status summary

**Conditions**: Always runs after all jobs complete

**Steps**:
1. Download all artifacts
2. Generate build summary with results
3. Display results in GitHub Actions interface

## Code Quality Tools

### JaCoCo Code Coverage

- **Plugin**: `jacoco-maven-plugin` (version 0.8.11)
- **Purpose**: Measure test coverage
- **Reports**: Generated in `target/site/jacoco/`
- **Integration**: Uploads to Codecov (if token provided)

### Checkstyle

- **Plugin**: `maven-checkstyle-plugin` (version 3.3.1)
- **Configuration**: `checkstyle.xml`
- **Purpose**: Code style validation
- **Severity**: Warning (non-blocking)

### PMD

- **Plugin**: `maven-pmd-plugin` (version 3.21.2)
- **Purpose**: Static code analysis
- **Configuration**: Non-blocking violations
- **Reports**: HTML and XML formats

### OWASP Dependency Check

- **Plugin**: `dependency-check-maven` (version 9.0.9)
- **Purpose**: Vulnerability scanning
- **Threshold**: Fails on CVSS ≥ 7.0
- **Reports**: HTML and XML formats

## Required Secrets

### Optional Secrets

- `CODECOV_TOKEN`: For uploading coverage to Codecov
- `SONAR_TOKEN`: For SonarCloud integration (if needed)

## Local Development

### Running CI Tools Locally

```bash
# Run tests with coverage
mvn test jacoco:report

# Run code quality checks
mvn checkstyle:check pmd:check

# Run security scan
mvn dependency-check:check

# Run all checks
mvn clean test jacoco:report checkstyle:check pmd:check dependency-check:check
```

### Configuration Files

- `checkstyle.xml`: Checkstyle rules configuration
- `pom.xml`: Maven plugins and dependencies

## Artifacts

### Test Results

- **Name**: `test-results-{os}-{java}`
- **Content**: Surefire and failsafe reports
- **Retention**: 7 days

### Coverage Reports

- **Name**: `coverage-reports`
- **Content**: JaCoCo HTML and XML reports
- **Retention**: 7 days

### Security Reports

- **Name**: `security-reports`
- **Content**: OWASP dependency check reports
- **Retention**: 30 days

## Performance Considerations

### Caching

- **Maven Dependencies**: Cached across workflow runs
- **Artifacts**: Limited retention periods to manage storage

### Parallel Execution

- **Test Matrix**: Runs in parallel across environments
- **Quality Jobs**: Run sequentially after tests complete

### Fail-fast Strategy

- **Test Matrix**: `fail-fast: false` - continues testing other environments
- **Quality Jobs**: Continue even if some checks fail

## Troubleshooting

### Common Issues

1. **Checkstyle Indentation Errors**: The current configuration uses 2-space indentation
2. **Maven Caching**: Cache may need to be cleared if dependencies change
3. **Java Version Compatibility**: Some combinations excluded for compatibility

### Debugging

- Check individual job logs in GitHub Actions
- Download artifacts for detailed analysis
- Run tools locally to reproduce issues

## Future Enhancements

### Potential Additions

1. **Performance Testing**: JMH benchmark integration
2. **Documentation Generation**: Javadoc and site generation
3. **Release Automation**: Semantic versioning and release publishing
4. **Integration Testing**: Database and external service testing

### Optimization Opportunities

1. **Conditional Testing**: Skip some jobs on specific branches
2. **Incremental Analysis**: Only analyze changed files
3. **Parallel Quality Checks**: Run Checkstyle and PMD in parallel

## Best Practices

### Code Quality

- Maintain test coverage above 80%
- Address Checkstyle warnings promptly
- Review PMD suggestions regularly
- Monitor security scan results

### Workflow Maintenance

- Update action versions regularly
- Review and optimize workflow performance
- Monitor artifact storage usage
- Update tool versions as needed

---

## Support

For questions or issues with the CI pipeline:
1. Check the GitHub Actions workflow logs
2. Review this documentation
3. Run tools locally to reproduce issues
4. Create an issue in the project repository
