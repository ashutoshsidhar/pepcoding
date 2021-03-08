// setTimeout(function(){                                        //SET TIMEOUT FUNCTION
//     console.log("hello");
// },5000);
// console.log("Yo");

// async function temp() {                                     // ASYNC FUNCTION
//     setTimeout(function(){
//         console.log("hello");
//     },5000);
// }

// temp();
// console.log("Hello");

async function temp() {                                      // PROBLEM 
    console.log("1");
    setTimeout(function(){
        console.log("2");
    },1000);
    console.log("3");
    setTimeout(function(){
        console.log("4");
    },1000);
}

temp();
console.log("5");