window.onload = function() {
    function getButton(i) {
        return document.getElementById('btn' + i);
    }

    getButton(5).onclick = function() {
        let temp = getButton(1).innerHTML;
        getButton(1).innerHTML = getButton(4).innerHTML;
        getButton(4).innerHTML = getButton(7).innerHTML;
        getButton(7).innerHTML = getButton(8).innerHTML;
        getButton(8).innerHTML = getButton(9).innerHTML;
        getButton(9).innerHTML = getButton(6).innerHTML;
        getButton(6).innerHTML = getButton(3).innerHTML;
        getButton(3).innerHTML = getButton(2).innerHTML;
        getButton(2).innerHTML = temp;
    };
};
