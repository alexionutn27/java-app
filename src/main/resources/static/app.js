async function loadJson(url) {
    const response = await fetch(url);
    if (!response.ok) {
        throw new Error(`Request failed: ${url}`);
    }
    return response.json();
}

function renderPipeline(items) {
    const container = document.getElementById("pipeline-list");
    container.innerHTML = "";
    items.forEach((item) => {
        const li = document.createElement("li");
        li.innerHTML = `
            <span>${item.step}</span>
            <span class="status ${item.status}">${item.status.toUpperCase()}</span>
        `;
        container.appendChild(li);
    });
}

async function init() {
    const [health, info, pipeline] = await Promise.all([
        loadJson("/api/health"),
        loadJson("/api/info"),
        loadJson("/api/pipeline")
    ]);

    document.getElementById("health-status").textContent =
        `Status: ${health.status} • Checked: ${health.checkedAt}`;

    document.getElementById("app-info").textContent =
        `${info.name} — ${info.message}`;

    renderPipeline(pipeline);
}

init().catch((error) => {
    document.getElementById("health-status").textContent = "Nu am putut încărca datele.";
    document.getElementById("app-info").textContent = error.message;
});

