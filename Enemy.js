class Enemy {
    x;
    y;
    canvas;
    ctx;
    width;
    height;
    color;
    speed = 0.1;
    constructor(x, y, width, height, color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.width = width;
        this.height = height;
        this.canvas = document.getElementById('canvas')
        this.ctx = this.canvas.getContext('2d')
    }
    draw() {
        this.setStyle()
        this.ctx.beginPath();
        this.ctx.fillRect(this.x, this.y, this.width, this.height)
        this.ctx.fillStyle = this.color;
        this.falling();

    }
    setStyle() {
        this.ctx.shadowColor = "#e79433";
        this.ctx.shadowBlur = 20;
        this.ctx.lineJoin = "bevel"
        this.ctx.lineWidth = 5;
    }
    collide(bullet) {
        if (bullet.y - bullet.radius <= this.y + this.height &&
            bullet.x + bullet.radius >= this.x &&
            bullet.x - bullet.radius <= this.x + this.width) {
            this.x = Math.random()* 650;
            this.y -= 50;
            return true;
        }
    }
    falling() {
        this.y += this.speed
    }

    gameOver() {
        if (this.y + this.height >= this.canvas.height) {
            return true
        }
    }
}