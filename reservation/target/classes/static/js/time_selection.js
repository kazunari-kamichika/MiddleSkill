let startDate = new Date(); // 開始日
const daysOfWeek = [];

// 1週間分の日付を生成する関数
function generateDaysOfWeek() {
	daysOfWeek.length = 0; // 配列をリセット
	for (let i = 0; i < 7; i++) {
		const nextDate = new Date(startDate);
		nextDate.setDate(startDate.getDate() + i);
		daysOfWeek.push(nextDate.toLocaleDateString());
	}
}

// 時間を設定（例：10時〜18時まで1時間刻み）
const timeSlots = [];
for (let hour = 10; hour <= 18; hour++) {
	timeSlots.push(`${hour}:00`);
}

// テーブルを更新する関数
function updateTable() {
	generateDaysOfWeek();

	const headerRow = document.querySelector('#timeSelectionTable thead tr');
	const tbody = document.querySelector('#timeSelectionTable tbody');

	// ヘッダーの更新
	headerRow.innerHTML = '<th>時間</th>'; // ヘッダーをリセット
	daysOfWeek.forEach(day => {
		const th = document.createElement('th');
		th.innerText = day;
		headerRow.appendChild(th);
	});

	// ボディの更新
	tbody.innerHTML = ''; // ボディをリセット
	timeSlots.forEach(time => {
		const tr = document.createElement('tr');
		const timeCell = document.createElement('td');
		timeCell.innerText = time;
		tr.appendChild(timeCell);

		daysOfWeek.forEach((_, index) => {
			const td = document.createElement('td');
			const radio = document.createElement('input');
			radio.type = 'radio';
			radio.name = `time-${daysOfWeek[index]}`;
			radio.id = `${time}-${daysOfWeek[index]}`;
			radio.value = `${time} (${daysOfWeek[index]})`;
			td.appendChild(radio);
			tr.appendChild(td);
		});

		tbody.appendChild(tr);
	});
}

// 初期化
updateTable();

// 選択確定ボタンの処理
const confirmButton = document.getElementById('confirmButton');
confirmButton.onclick = () => {
	const selectedTimes = [];
	daysOfWeek.forEach((_, index) => {
		const radio = document.querySelector(`input[name="time-${daysOfWeek[index]}"]:checked`);
		if (radio) {
			selectedTimes.push(radio.value);
		}
	});

	if (selectedTimes.length > 0) {
		alert(`選択した日時: ${selectedTimes.join(', ')}`);
		window.location.href = "reservation_input.html";
	} else {
		alert('時間を選択してください。');
	}
};

// ラジオボタンが選択されたらボタンを表示
const radios = document.querySelectorAll('input[type="radio"]');
radios.forEach(radio => {
	radio.onchange = () => {
		confirmButton.style.display = 'block';
	};
});

// 週を進めるボタンの処理
document.getElementById('nextWeekButton').onclick = () => {
	startDate.setDate(startDate.getDate() + 7); // 1週間後に移動
	updateTable(); // テーブルを更新
};

// 週を戻すボタンの処理
document.getElementById('prevWeekButton').onclick = () => {
	const today = new Date();
	if (startDate > today) { // 今日より前には戻れない
		startDate.setDate(startDate.getDate() - 7); // 1週間戻る
		updateTable(); // テーブルを更新
	} else {
		alert('今日以前には戻れません。');
	}
};
