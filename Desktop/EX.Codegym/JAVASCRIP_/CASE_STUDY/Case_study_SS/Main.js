let bullet = new Bullet(260, 400, 5, 'black')
let gun = new Gun(250, 450, 20, 40, 'black')
let ctx = document.getElementById('canvas').getContext('2d')
let point = 0;
let lever = 1
let pushLever = document.getElementById('lever')
let gameOver = false;
let pushPoint = document.getElementById('ouput');
let enemyArr = [
    new Enemy(Math.floor(Math.random() * 650), Math.floor(Math.random() * 100), 70,70, '#EF5350'),
    new Enemy(Math.floor(Math.random() * 650), Math.floor(Math.random() * 100), 70,70, '#EC407A'),
    new Enemy(Math.floor(Math.random() * 650), Math.floor(Math.random() * 100), 70,70, '#2196F3'),
    new Enemy(Math.floor(Math.random() * 650), Math.floor(Math.random() * 100), 70,70, '#00E676'),
    new Enemy(Math.floor(Math.random() * 650), Math.floor(Math.random() * 100), 70,70, '#FFEE58'),
    new Enemy(Math.floor(Math.random() * 650), Math.floor(Math.random() * 100), 70,70, '#8D6E63'),
    new Enemy(Math.floor(Math.random() * 650), Math.floor(Math.random() * 100), 70,70, '#FF6F00'),
    new Enemy(Math.floor(Math.random() * 650), Math.floor(Math.random() * 100), 70,70, '#26C6DA'),
    new Enemy(Math.floor(Math.random() * 650), Math.floor(Math.random() * 100), 70,70, '#78909C'),
    new Enemy(Math.floor(Math.random() * 650), Math.floor(Math.random() * 100), 70,70, '#D4E157'),
    new Enemy(Math.floor(Math.random() * 650), Math.floor(Math.random() * 100), 70,70, '#9CCC65'),
    new Enemy(Math.floor(Math.random() * 650), Math.floor(Math.random() * 100), 70,70, '#66BB6A')
];
/** run mảng enemy */
function runAnemy() {
    enemyArr.forEach((enemy2, index) => {
        enemy2.draw();
        if (enemy2.collide(bullet) === true) {
            point += 1
            pushPoint.innerHTML = point;
            enemyArr[index].width -= 10;
            enemyArr[index].height -= 10
            if (enemyArr[index].width <= 20) {
                enemyArr.splice(index,1)
                enemyArr.push( new Enemy(Math.floor(Math.random() * 650), Math.floor(Math.random() * 100), 70,70, getRandomColor()))
            }
        }

        // Tăng lever
        if (point >= 50 && point < 150) {
            lever = 2
            pushLever.innerHTML = lever
            enemy2.speed = 0.3
        }
        if (point >= 150 && point < 300) {
            lever = 3
            pushLever.innerHTML = lever
            enemy2.speed = 0.4
        }
        if (point >= 300) {
            lever = 3
            pushLever.innerHTML = lever
            enemy2.speed = 0.8
        }
        if (enemy2.gameOver() === true) {
            gameOver = true;
            endGame();
        }
    })
}

/** Tạo random màu */
function getRandomHex(){
    return Math.floor(Math.random()*255);
}

function getRandomColor(){
    var red = getRandomHex();
    var green = getRandomHex();
    var blue = getRandomHex();
    return "rgb(" + red + "," + blue + "," + green +")";
}
function play() {
    if (!gameOver) {
        bullet.shoot();
        bullet.draw();
        gun.draw();
        runAnemy()
        requestAnimationFrame(play)
    }
}
play();

/** End game*/
function endGame () {
    ctx.font = "45px Arial";
    ctx.fillText("GAME OVER",200,220);
}

/** Hàm tính điểm */
// Bắt sự kiện súng sang trái phải
window.addEventListener('keydown', (event) => {
    let key = event.keyCode;
    console.log(key)
    switch (key) {
        case 32:
            if (gameOver === true) {
                location.reload();
            }
            break;
        case 37:
            gun.moveLeft();
            bullet.followGunLeft(gun)
            break;
        case 39:
            gun.moveRight();
            bullet.followGunRight(gun);
            break;
    }
})