// validation.js

document.addEventListener("DOMContentLoaded", () => {
    // Select all forms with the class "needs-validation"
    const forms = document.querySelectorAll(".needs-validation");

    forms.forEach(form => {
        form.addEventListener("submit", (event) => {
            // Prevent form submission if validation fails
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add("was-validated");
        });
    });

    // Real-time email validation
    const emailField = document.getElementById("email");
    const emailError = document.getElementById("emailError");
    if (emailField) {
        emailField.addEventListener("input", () => {
            const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
            if (!emailPattern.test(emailField.value)) {
                emailError.textContent = "Please enter a valid email address.";
                emailField.classList.add("is-invalid");
                emailField.classList.remove("is-valid");
            } else {
                emailError.textContent = "";
                emailField.classList.add("is-valid");
                emailField.classList.remove("is-invalid");
            }
        });
    }

    // Password strength validation
    const passwordField = document.getElementById("password");
    const passwordStrength = document.getElementById("passwordStrength");
    if (passwordField) {
        passwordField.addEventListener("input", () => {
            const password = passwordField.value;
            let strength = 0;

            if (password.length >= 8) strength++;
            if (/[A-Z]/.test(password)) strength++;
            if (/[a-z]/.test(password)) strength++;
            if (/[0-9]/.test(password)) strength++;
            if (/[@$!%*?&#]/.test(password)) strength++;

            if (strength === 0) {
                passwordStrength.textContent = "";
                passwordField.classList.remove("is-invalid", "is-valid");
            } else if (strength <= 2) {
                passwordStrength.textContent = "Weak password.";
                passwordField.classList.add("is-invalid");
                passwordField.classList.remove("is-valid");
            } else if (strength <= 4) {
                passwordStrength.textContent = "Moderate password.";
                passwordField.classList.add("is-valid");
                passwordField.classList.remove("is-invalid");
            } else {
                passwordStrength.textContent = "Strong password!";
                passwordField.classList.add("is-valid");
                passwordField.classList.remove("is-invalid");
            }
        });
    }

    // Required field validation
    const requiredFields = document.querySelectorAll("[required]");
    requiredFields.forEach(field => {
        field.addEventListener("blur", () => {
            if (!field.value.trim()) {
                field.classList.add("is-invalid");
                field.classList.remove("is-valid");
            } else {
                field.classList.add("is-valid");
                field.classList.remove("is-invalid");
            }
        });
    });
});
