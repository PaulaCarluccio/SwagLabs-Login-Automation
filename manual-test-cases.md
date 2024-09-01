# Swag Labs Login Test Cases

## Test Case 1: [standard_user] - Successful login with valid credentials

1. Navigate to Swag Labs login page.
2. Enter the username `standard_user` and password.
3. Click on Login button.

**Expected result:** The user is successfully logged in and redirected to the Products page. The inventory items are displayed correctly.

## Test Case 2: [locked_out_user] - Unsuccessful login with valid credentials

1. Navigate to Swag Labs login page.
2. Enter the username `locked_out_user` and password.
3. Click on Login button.

**Expected result:** An error message appears indicating that the user is locked out: "Epic sadface: Sorry, this user has been locked out." and remains on the login page.

## Test Case 3: [problem_user] - Successful login with valid credentials

1. Navigate to Swag Labs login page.
2. Enter the username `problem_user` and password.
3. Click on Login button.

**Expected result:** The user is successfully logged in and redirected to the Products page. The inventory items are displayed correctly.

## Test Case 4: [performance_glitch_user] - Successful login with valid credentials

1. Navigate to Swag Labs login page.
2. Enter the username `performance_glitch_user` and password.
3. Click on Login button.

**Expected result:** The user is successfully logged in and redirected to the Products page. The inventory items are displayed correctly.

## Test Case 5: [Invalid username] - Unsuccessful login with invalid username

1. Navigate to Swag Labs login page.
2. Enter an invalid username and password.
3. Click on Login button.

**Expected result:** An error message appears indicating that the user is locked out: "Epic sadface: Username and password do not match any user in this service." and remains on the login page.

## Test Case 6: [Invalid password] - Unsuccessful login with invalid password

1. Navigate to Swag Labs login page.
2. Enter a valid username and incorrect password.
3. Click on Login button.

**Expected result:** An error message appears indicating that the user is locked out: "Epic sadface: Username and password do not match any user in this service." and remains on the login page.
