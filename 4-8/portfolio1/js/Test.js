$('.slider').slick({
    autoplay: true,       //自動再生
    autoplaySpeed: 3000,  //自動再生のスピード
    speed: 800,           //スライドするスピード
    dots: true,           //スライド下のドット
    arrows: true,         //左右の矢印
    infinite: true,       //永久にループさせる
});


// 画像をクリックしたときに拡大表示
const images = document.querySelectorAll('.slick-area img');
const popup = document.getElementById('popup');
const popupImg = document.getElementById('popup-img');
const closeBtn = document.querySelector('.close');

images.forEach((img) => {
    img.addEventListener('click', function() {
        popupImg.src = this.src; // クリックした画像のsrcをポップアップに設定
        popup.classList.add('show'); // ポップアップを表示
    });
});

// ポップアップの閉じるボタンや背景をクリックしたら元に戻る
closeBtn.addEventListener('click', function() {
    popup.classList.remove('show');
});

popup.addEventListener('click', function(e) {
    if (e.target === popup) {
        popup.classList.remove('show');
    }
});

images.forEach((img) => {
    img.addEventListener('click', function() {
        popupImg.src = this.src; // クリックした画像のsrcをポップアップに設定
        popupImg.style.display = 'block'; // 画像を表示
        popupImg.style.width = '100%'; // 画像の幅を100%に設定
        popupImg.style.height = 'auto'; // 高さは自動で調整
        popup.classList.add('show'); // ポップアップを表示
    });
});