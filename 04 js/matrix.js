var c = document.getElementById("c");
var ctx = c.getContext("2d");

c.width = window.innerWidth;
c.height = window.innerHeight;

var symbols = "0 1".split("");

var size = 10;
var columns = c.width / size;

var drops = [];

for (var i = 0; i < columns; i++) {
	drops[i] = 1;
}

function draw() {
	ctx.fillStyle = "rgba(0, 0, 0, 0.05)";
	ctx.fillRect(0, 0, c.width, c.height);
	
	ctx.fillStyle = "#0f0";
	ctx.fontSize = size + "px";
	
	for (var i = 0; i < drops.length; i++) {
		var text = symbols[Math.floor(Math.random() * symbols.length)];
		ctx.fillText(text, i * size, drops[i] * size);
		
		if (drops[i] * size > c.height && Math.random() > 0.98) {
			drops[i] = 0;
		}
		
		drops[i]++;
	}
	
}

setInterval(draw, 50);