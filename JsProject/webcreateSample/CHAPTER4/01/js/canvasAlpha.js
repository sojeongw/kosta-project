(function() {

var create_alpha_jpeg = function(img) {

var alpha_path = img.getAttribute('data-alpha-src')
if(!alpha_path) return

// オリジナル画像を隠す
img.style.visiblity = 'hidden'

// アルファ無し画像をプリロード
var image = document.createElement('img')
image.src = img.src
image.onload = function () {

// アルファマスク画像をプリロード
var alpha = document.createElement('img')
alpha.src = alpha_path
alpha.onload = function () {

var canvas = document.createElement('canvas')
canvas.width = image.width
canvas.height = image.height
img.parentNode.replaceChild(canvas, img)

// カンバスでの合成
var context = canvas.getContext('2d')

context.clearRect(0, 0, image.width, image.height)
//canvas上に画像を表示(JPEG)
context.drawImage(image, 0, 0, image.width, image.height)
//JPEGとマスク画像を合体
context.globalCompositeOperation = 'xor'
//canvas上に画像を表示(マスク)
context.drawImage(alpha, 0, 0, image.width, image.height)
}
}
}

// ページの読み込みが終わっていたら実行
var imgs = document.getElementsByTagName('img')
for(var i = 0; i < imgs.length; i++)
create_alpha_jpeg(imgs[i])

})();

