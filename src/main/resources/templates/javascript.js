"use strict";
const getOrders = async () => {
    return await fetch("http://localhost:8080/orders", {
        method: "GET"
    }).then(res=> res.json())
}

const createOrder = async (client, address) => {
    return await fetch("http://localhost:8080/orders", {
        method: "POST",
        headers: {
            "content-type": "application/json"
        },
        body: JSON.stringify({client: client, address: address, Date: new Date().getTime()})
    }).then(res => res.json());
}

const getById = async (id) => {
    return await fetch(`http://localhost:8080/orders/${id}`, {
        method: "GET"
    }).then(res => res.json())
}

const updateById = async (id, client, address) => {
    return await  fetch(`http://localhost:8080/orders`, {
        method: "PUT",
        headers: {
            "content-type": "application/json"
        },
        body: JSON.stringify({id: id,client: client, address: address, Date: new Date()})
    })
}

async function testAPI() {
    const createVovan = await createOrder( "Niko", "Moscow");
    console.log("CREATED VOVAN", createVovan);
    const orders = await getOrders();
    console.log("ORDERS", orders);
    const orderGetById = await getById(2);
    console.log("ORDER GET BY ID", orderGetById);
    const update = await updateById(2, "Vovanchik", "Komarova");
    console.log("UPDATE", update);
}

async function tableCreate() {
    const orders = await getOrders();
    console.log("ORDERS", orders);
    var body = document.getElementsByTagName('body')[0];
    var tbl = document.createElement('table');
    tbl.style.width = '100%';
    tbl.style.height = '100%';
    tbl.setAttribute('border', '1');
    var tbdy = document.createElement('tbody');
    for (var i = 0; i < orders.length; i++) {
        var tr = document.createElement('tr');
        for (var j = 0; j < 4; j++) {
            if (i == 2 && j == 1) {
                break
            } else {
                for (let i = 0; i < orders.length; i++) {
                    var td = document.createElement('td');
                    td.appendChild(document.createTextNode(orders[i].id));
                    td.appendChild(document.createTextNode(orders[i].client));
                    td.appendChild(document.createTextNode(orders[i].address));
                    td.appendChild(document.createTextNode(orders[i].date));
                    i == 1 && j == 1 ? td.setAttribute('rowSpan', '2') : null;
                    tr.appendChild(td)
                }
            }
        }
        tbdy.appendChild(tr);
    }
    tbl.appendChild(tbdy);
    body.appendChild(tbl)

}

tableCreate();

testAPI();