class Bullet {
    x;
    y;
    radius;
    canvas;
    ctx;
    color;
    speed = 20;
    gunleft = 40;
    gunright = 40;
    constructor(x, y, radius, color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.canvas = document.getElementById('canvas');
        this.ctx = this.canvas.getContext('2d')
    }
    draw() {
        this.ctx.beginPath();
        this.ctx.arc(this.x, this.y, this.radius, 0, 2*Math.PI)
        this.ctx.fillStyle = this.color
        this.ctx.fill();
    }
    shoot() {
        this.ctx.clearRect(0, 0, this.canvas.width, this.canvas.height);
        this.y -= this.speed
        if (this.y - this.radius <= 0) {
            this.y = gun.y;
        }
    }
    followGunLeft(gun) {
            this.x -= this.gunleft
    }
    followGunRight(gun) {
        this.x += this.gunright
    }

}