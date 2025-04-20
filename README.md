# Selenium Java Automation Framework

This repository hosts a robust and scalable Selenium automation framework developed in Java. It integrates **TestNG** with **Cucumber**, employs the **Page Object Model (POM)** design pattern, ensures **thread-safe parallel execution**, and utilizes **ChainTest** for comprehensive reporting.

## Overview

The framework is designed to facilitate efficient and maintainable automated testing for web applications. By leveraging industry-standard tools and design patterns, it aims to provide a reliable solution for continuous integration and delivery pipelines.

## Features

The automation framework integrates TestNG with Cucumber to support behavior-driven development (BDD) while retaining the flexibility and parallelism features of TestNG. The test structure follows the Page Object Model (POM) to keep test code clean, readable, and reusable. A thread-safe driver setup using `ThreadLocal<WebDriver>` enables tests to run in parallel across different threads without conflicts. Additionally, ChainTest reporting provides visually rich and easy-to-analyze HTML reports with step logs, screenshots, and test status for each execution.

## Project Structure

The framework is organized into a Maven-based project layout, as shown below:

