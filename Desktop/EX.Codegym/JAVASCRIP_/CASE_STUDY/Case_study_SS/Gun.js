class Gun {
    x;
    y;
    canvas;
    ctx;
    width;
    height;
    color;
    followGunLeft = 40;
    followGunRight = 40;
    constructor(x, y, width, height, color) {
        this.x = x;
        this.y = y;
        this.color = color
        this.width = width;
        this.height = height;
        this.canvas = document.getElementById('canvas')
        this.ctx = this.canvas.getContext('2d')
    }
    clearGun() {
        this.ctx.clearRect(this.x, this.y, this.canvas.width, this.canvas.height);
    }
    draw() {
        this.ctx.beginPath();
        this.ctx.fillRect(this.x, this.y, this.width, this.height)
        this.ctx.fillStyle = this.color
        this.ctx.fill();
    }
    moveLeft() {
        this.clearGun()
        this.x -= this.followGunLeft
    }
    moveRight() {
        this.clearGun()
        this.x += this.followGunRight
    }

}