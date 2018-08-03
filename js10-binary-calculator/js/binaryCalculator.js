window.onload = function() {
    function append_result_action(e) {
        let btn = e.target || e.srcElement;

        document.getElementById('res').innerHTML += btn.innerHTML;
    }

    document.getElementById('btn0').onclick = append_result_action;
    document.getElementById('btn1').onclick = append_result_action;
    document.getElementById('btnSum').onclick = append_result_action;
    document.getElementById('btnSub').onclick = append_result_action;
    document.getElementById('btnMul').onclick = append_result_action;
    document.getElementById('btnDiv').onclick = append_result_action;

    document.getElementById('btnClr').onclick = function() {
        document.getElementById('res').innerHTML = '';
    };

    document.getElementById('btnEql').onclick = function() {
        let res = document.getElementById('res').innerHTML;

        let operatorIndex = 0;
        while (!'+-*/'.includes(res[operatorIndex])) {
            operatorIndex++;
        }

        let operand1 = parseInt(res.substring(0, operatorIndex), 2);
        let operator = res[operatorIndex];
        let operand2 = parseInt(res.substring(operatorIndex + 1), 2);

        document.getElementById('res').innerHTML = Math.floor(eval(operand1 + operator + operand2)).toString(2);
    };
};