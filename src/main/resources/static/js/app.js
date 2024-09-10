function openTab(evt, tabName) {
    var i, tabcontent, tablinks;

    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}

function openSubTab(subTabName) {
    var i, subtabcontent;

    subtabcontent = document.getElementsByClassName("subtabcontent");
    for (i = 0; i < subtabcontent.length; i++) {
        subtabcontent[i].style.display = "none";
    }

    document.getElementById(subTabName).style.display = "block";
}

document.getElementById("asset-form").addEventListener("submit", async function(event) {
    event.preventDefault();

    const data = {
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        address: document.getElementById("address").value,
        phoneNumber: document.getElementById("phoneNumber").value,
        yearBuilt: parseInt(document.getElementById("yearBuilt").value),
        buildingValue: parseFloat(document.getElementById("buildingValue").value),
        contentValue: parseFloat(document.getElementById("contentValue").value)
    };

    const response = await fetch("/api/assets", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });

    const result = await response.json();
    document.getElementById("calculationResult").innerText = `Numer kalkulacji: ${result.id}, Składka: ${result.premium}`;
});