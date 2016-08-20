function addRow() {
    var grantName = document.getElementById("grantName");
    var minDuration = document.getElementById("minDuration");
    var maxDuration = document.getElementById("maxDuration");
    var minAmount = document.getElementById("minAmount");
    var maxAmount = document.getElementById("maxAmount");

    var table = document.getElementById("GrantConditionShowTable");
    var rowNumber = table.rows.length;
    if( rowNumber == 0){
        makeTable();
    }
    
}

function makeTable() {
    var table = document.getElementById("GrantConditionShowTable");
    var rowNumber = table.rows.length;
    var row = table.insertRow(rowNumber);
    var cell = document.createElement("GrantTable");
    cell.innerHTML = "ردیف";
    row.appendChild(cell);
    cell = document.createElement("GrantTable");
    cell.innerHTML = "نام شرط";
    row.appendChild(cell);
    cell = document.createElement("GrantTable");
    cell.innerHTML = "حداقل مدت قرارداد";
    row.appendChild(cell);
    cell = document.createElement("GrantTable");
    cell.innerHTML = "حداکثر مدت قرارداد";
    row.appendChild(cell);
    cell = document.createElement("GrantTable");
    cell.innerHTML = "حداقل مبلغ قرارداد";
    row.appendChild(cell);
    cell = document.createElement("GrantTable");
    cell.innerHTML = "حداکثر مبلغ قرارداد";
    row.appendChild(cell);
    cell = document.createElement("GrantTable");
    cell.innerHTML = "عملیات";
    row.appendChild(cell);
}