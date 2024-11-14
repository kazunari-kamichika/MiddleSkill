document.addEventListener("DOMContentLoaded", () => {
    const calendarTable = document.getElementById("calendar");
    const confirmButton = document.getElementById("confirmButton");
    const prevWeekButton = document.getElementById("prevWeek");
    const nextWeekButton = document.getElementById("nextWeek");

    let currentDate = new Date();

    // カレンダーを表形式で表示
    function renderCalendar(date) {
        calendarTable.innerHTML = ""; // カレンダー表をクリア
        const startHour = 10; // 開始時間
        const endHour = 21;  // 終了時間
        const daysToShow = 7;

        // 見出し行を作成
        const headerRow = document.createElement("tr");
        const timeHeader = document.createElement("th");
        timeHeader.textContent = "時間";
        headerRow.appendChild(timeHeader);

        // 各日のヘッダーを作成
        for (let i = 0; i < daysToShow; i++) {
            const day = new Date(date);
            day.setDate(date.getDate() + i);

            const dayHeader = document.createElement("th");
            dayHeader.textContent = day.toLocaleDateString("ja-JP", { month: "numeric", day: "numeric", weekday: "short" });
            headerRow.appendChild(dayHeader);
        }
        calendarTable.appendChild(headerRow);

        // 時間ごとの行を作成
        for (let hour = startHour; hour <= endHour; hour++) {
            const row = document.createElement("tr");
            const timeCell = document.createElement("th");
            timeCell.textContent = `${hour}:00`;
            row.appendChild(timeCell);

            // 各日付ごとに時間スロットを作成
            for (let i = 0; i < daysToShow; i++) {
                const day = new Date(date);
                day.setDate(date.getDate() + i);
                day.setHours(hour, 0, 0, 0);

                const cell = document.createElement("td");
                const timeSlot = document.createElement("input");
                timeSlot.type = "radio";
                timeSlot.name = "timeSlot";
                timeSlot.value = day.toISOString();
                timeSlot.classList.add("time-slot");

                cell.appendChild(timeSlot);
                row.appendChild(cell);

                // 時間スロットが選択されたら確定ボタンを有効化
                timeSlot.addEventListener("change", () => {
                    confirmButton.disabled = false;
                });
            }
            calendarTable.appendChild(row);
        }
    }

    // 前の週ボタン
    prevWeekButton.addEventListener("click", () => {
        currentDate.setDate(currentDate.getDate() - 7);
        renderCalendar(currentDate);
        updateNavigationButtons();
    });

    // 次の週ボタン
    nextWeekButton.addEventListener("click", () => {
        currentDate.setDate(currentDate.getDate() + 7);
        renderCalendar(currentDate);
        updateNavigationButtons();
    });

    // 前の週への移動を無効化するかどうかを更新
    function updateNavigationButtons() {
        const today = new Date();
        today.setHours(0, 0, 0, 0); // 今日の日付
        prevWeekButton.disabled = currentDate <= today;
    }

    // 初期表示
    renderCalendar(currentDate);
    updateNavigationButtons();
});
