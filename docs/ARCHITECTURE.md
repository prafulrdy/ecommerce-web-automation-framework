# Architecture

```text
Tests
  ↓
Page Objects
  ↓
Selenium WebDriver
  ↓
Browser / SauceDemo
```

Layers:
- Base: browser lifecycle
- Pages: reusable locators and actions
- Tests: assertions and workflows
- Utilities: screenshots/helpers
- CI/CD: GitHub Actions and Jenkins
