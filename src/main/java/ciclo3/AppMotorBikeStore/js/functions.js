
//----- Script modulo Categoria -----//

function postCategory(){
    let category = {
        name:$("#nameCategory").val(),
        description:$("#descriptionCategory").val()
        };      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(category),        
        url:"http://152.67.33.106:8080/api/Category/save",       
        success:function(response) {
            console.log(response);
            console.log("Se guardo correctamente");
            alert("Se guardo correctamente");
            window.location.reload()
        },
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
        }
    });
    
}

getCategory();

function getCategory(){
    $.ajax({
        url:"http://152.67.33.106:8080/api/Category/all",
        type:"GET",
        datatype:"JSON",
        success:function(resultCategory){
            console.log(resultCategory);
            boardCategory(resultCategory);
        }
    });
}

function boardCategory(resultCategory){

    let tableCategory="<table>";
    for(i=0;i<resultCategory.length;i++){
        tableCategory+="<tr>";
        tableCategory+="<td>"+resultCategory[i].id+"</td>";
        tableCategory+="<td>"+resultCategory[i].name+"</td>";
        tableCategory+="<td>"+resultCategory[i].description+"</td>";
        tableCategory+="<td><button onclick='putCategory("+resultCategory[i].id+")'>Actualizar</button>";
        tableCategory+="<td><button onclick='deleteCategory("+resultCategory[i].id+")'>Borrar</button>";
        tableCategory+="</tr>";
    }
    tableCategory+="</table>";
    $("#category").html(tableCategory);
}

function deleteCategory(idCategory){
    let myData={
        id:idCategory
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://152.67.33.106:8080/api/Category/"+idCategory,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(response){
            $("#resultado").empty();
            getCategory();
            alert("Se ha Eliminado.")
        }
    });

}

//----- Script modulo Cliente -----//

function postClient(){
    let client = {
        name:$("#nameClient").val(),
        email:$("#email").val(),
        password:$("#password").val(),
        age:$("#age").val()
        };      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(client),        
        url:"http://152.67.33.106:8080/api/Client/save",       
        success:function(response) {
            console.log(response);
            console.log("Se guardo correctamente");
            alert("Se guardo correctamente");
            window.location.reload()
        },
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
        }
    });
    
}

getClient();

function getClient(){
    $.ajax({
        url:"http://152.67.33.106:8080/api/Client/all",
        type:"GET",
        datatype:"JSON",
        success:function(resultClient){
            console.log(resultClient);
            boardClient(resultClient);
        }
    });
}

function boardClient(resultClient){

    let tableClient="<table>";
    for(i=0;i<resultClient.length;i++){
        tableClient+="<tr>";
        tableClient+="<td>"+resultClient[i].idClient+"</td>";
        tableClient+="<td>"+resultClient[i].email+"</td>";
        tableClient+="<td>"+resultClient[i].password+"</td>";
        tableClient+="<td>"+resultClient[i].name+"</td>";
        tableClient+="<td>"+resultClient[i].age+"</td>";
        tableClient+="<td><button onclick='putClient("+resultClient[i].idClient+")'>Actualizar</button>";
        tableClient+="<td><button onclick='deleteClient("+resultClient[i].idClient+")'>Borrar</button>";
        tableClient+="</tr>";
    }
    tableClient+="</table>";
    $("#client").html(tableClient);
}

function deleteClient(idClient){
    let myData={
        id:idClient
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://152.67.33.106:8080/api/Client/"+idClient,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(response){
            $("#resultado").empty();
            getClient();
            alert("Se ha Eliminado.")
        }
    });

}