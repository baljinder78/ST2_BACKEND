


function loaded()
{


    var xhttp1 = new XMLHttpRequest();
    xhttp1.open("GET", "http://localhost:8080/trying", true);
    xhttp1.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var list=JSON.parse(this.responseText);
            for(var i=0;i<list.length;i++)
            {

                users(list[i]);
            }

        }
    };
    xhttp1.send();

}


function AJAXCALL()
{
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/trying", true);
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

        }
    };
  var Name=document.getElementById("Name").value;
  var mob_no=document.getElementById("mob_no").value;
  var email=document.getElementById("email").value;

    var json={
        "name":Name,
        "mobile_no":mob_no,
        "email":email,
    };
    xhttp.send(JSON.stringify(json));
    ADDdataonload(Name,mob_no,email);


}

function users(data)
{
    let resultdata=data;

    let N=resultdata.name;
    let m=resultdata.mobile_no;
     let e=resultdata.email;
    let id=resultdata.id;
    ADDdataonload(N,m,e);
}


function ADDdataonload(Name,mob_no,email) {




    /*
    var Name=document.getElementById("Name").value;
    var mob_no=document.getElementById("mob_no").value;
    var email=document.getElementById("email").value;

        if (Name === "")
        {
            alert("Please enter your Name");
//return false;
        }

        if (mob_no === "")
        {
            alert("Please enter your number");
//return false;
        }


        if (email === "")
        {
            alert("Please enter your email");
//return false;
        }

*/
//return true;



    //creat a table
    var table=document.getElementById("result_table");

    var tr = document.createElement("TR");

        let td = document.createElement("TD");
    let td_p_1 = document.createElement("P");
    let inp_1 = document.createTextNode(Name);
        td_p_1.appendChild(inp_1);
        td_p_1.setAttribute("class", "imp");
        td.appendChild(td_p_1);

        tr.appendChild(td);

    let td_2 = document.createElement("TD");
    let td_p_2 = document.createElement("P");
    let inp_2 = document.createTextNode(mob_no);
        td_p_2.appendChild(inp_2);
        td_p_2.setAttribute("class", "imp");
        td_2.appendChild(td_p_2);
        tr.appendChild(td_2);

    let td_3 = document.createElement("TD");
    let td_p_3 = document.createElement("P");
    let inp_3 = document.createTextNode(email);
        td_p_3.appendChild(inp_3);
        td_p_3.setAttribute("class", "imp");
        td_p_3.setAttribute("id","eme");
        td_3.appendChild(td_p_3);
        tr.appendChild(td_3);

    let td_4 = document.createElement("TD");
    let delet = document.createElement("Button");
    let text_btn = document.createTextNode("Delete")
        delet.appendChild(text_btn);
        delet.setAttribute("onclick", "delete_user(this)");
        delet.setAttribute("class", "delete_btn");
        td_4.appendChild(delet);

        tr.appendChild(td_4);

        table.appendChild(tr);

}





function delete_user(el) {

   var email_data=el.parentNode.parentNode.querySelector("#eme").textContent;

    var td_d = event.target.parentNode;
    var tr_D = td_d.parentNode;
    tr_D.parentNode.removeChild(tr_D);
    let id=tr_D.value;
    var xhttp1 = new XMLHttpRequest();
    xhttp1.open("DELETE", "http://localhost:8080/trying", true);
    xhttp1.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {


        }
    };
    xhttp1.send(email_data);

}