let button = document.createElement('button');
button.id = 'btn';
button.innerHTML = '0';
button.onclick = function() {
    btn.innerHTML++;
};

document.body.appendChild(button);
