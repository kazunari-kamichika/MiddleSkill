// calculateTotal.js

document.addEventListener("DOMContentLoaded", function () {
    const checkboxes = document.querySelectorAll(".plan-checkbox");
    const totalPriceElement = document.getElementById("totalPrice");

    checkboxes.forEach(checkbox => {
        checkbox.addEventListener("change", updateTotalPrice);
    });

    function updateTotalPrice() {
        let total = 0;
        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                total += parseFloat(checkbox.getAttribute("data-price"));
            }
        });
        totalPriceElement.textContent = total.toLocaleString();
    }
});
