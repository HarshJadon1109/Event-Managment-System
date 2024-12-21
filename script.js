// Form Validation
document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector(".contact-form");
    const nameInput = form.querySelector("input[type='text']");
    const emailInput = form.querySelector("input[type='email']");
    const messageInput = form.querySelector("textarea");

    form.addEventListener("submit", (event) => {
        event.preventDefault(); // Prevent form submission for validation

        let isValid = true;
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        // Name validation
        if (nameInput.value.trim() === "") {
            alert("Name is required.");
            isValid = false;
        }

        // Email validation
        if (!emailRegex.test(emailInput.value)) {
            alert("Please enter a valid email address.");
            isValid = false;
        }

        // Message validation
        if (messageInput.value.trim() === "") {
            alert("Message cannot be empty.");
            isValid = false;
        }

        // If valid, show confirmation
        if (isValid) {
            alert("Thank you for contacting us! We will get back to you shortly.");
            form.reset();
        }
    });

    // Interactivity: Add hover effects to event buttons
    const eventButtons = document.querySelectorAll(".event-card button");

    eventButtons.forEach((button) => {
        button.addEventListener("mouseover", () => {
            button.style.backgroundColor = "#4CAF50";
            button.style.color = "#fff";
        });

        button.addEventListener("mouseout", () => {
            button.style.backgroundColor = "";
            button.style.color = "";
        });
    });
});
