const fs = require("fs");

// function callback(err,data) {
//     if(err) {
//         console.log("unable to read file!");
//     } else {
//         console.log(data);
//     }
// }

// fs.readFile("abc.txt","utf-8",callback);
// function doublePrint(val,myname) {
//     console.log(val);
//     myname(undefined, val);
// }
// doublePrint("hello",callback);

// function print (val) {
//     console.log(val)
// }
// setTimeout(function(){
//     print("hello1");
// },2000);
// setTimeout(function(){
//     print("hello2");
// },1000);
// setTimeout(function(){
//     print("hello3");
// },5000);
// console.log("start");

// let cond = true;

// setTimeout(function(){
//     cond = false;
// },3000);

// while(cond) {
//     console.log("hello");
// }
// let count = 1;

// function readfile(filename) {
//     if(filename == undefined) {
//         filename = (count-1) + ".txt";
//     }
//     fs.readFile(filename,"utf-8",writefile);
// }

// function writefile(err,data) {
//     let lines = data.split("\r\n");
//     if(lines.length > 1) {
//         lines = lines.splice(1);
//         let writeData = lines.join("\r\n");
//         fs.writeFile(count +".txt",writeData,readfile);
//         count += 1;
//     }
// }

// readfile("abc.txt");
// let count = 1;

// function readfile(filename) {
//     if(filename == undefined) {
//         filename = (count -1) + ".txt";
//     }
//     fs.readFile(filename,"utf-8",writefile)
// }

// function writefile(err,data) {
//     let lines = data.split("\r\n");
//     if(lines.length > 1) {
//         lines = lines.splice(1);
//         let writeData = lines.join("\r\n");
//         fs.writeFile(count + ".txt",writeData,readfile);
//         count += 1;
//     }
// }

// readfile("abc.txt");


// let a = true;
// setInterval(() => {
//     if(a) console.log("hello");
// }, 2000);

// setTimeout(() => {
//     a = false;
// }, 10100);

// function myFilter(my_array, callback){
//     //Enter your code here
//     let arr = [];
//    for(let ele of my_array) {
//        if(callback(ele)) {
//            arr.push(ele);
//        }
//    }
//     return arr;
  
  
  
// }

// function callback(element) {
//     return element % 2 == 0;
// }

// function processData(inputArray) {
//     //In blank write anonymous function, which takes one parameter and returns true if its even or false if its odd.
//     console.log(myFilter(inputArray, callback));   
// }
let n = process.argv[2];
let fileno = 1 ;
// function createfiles(){
//     if(fileno > n ){
//         return;
//     }
//     let lines = Math.floor(Math.random() * 101);
//     let arr = [];
//     for(let i = 0 ; i < lines ; i++){
//         arr.push(Math.floor(Math.random() * 101));
//     }
//     let writeD = arr.join("\r\n");
//     fs.writeFile(fileno + ".txt",writeD,createfiles);
//     console.log("You Just Created Filenumber " + fileno);
//     fileno += 1 ;
// }
// createfiles();
// function readfiles(fileno){
//     console.log("You Just Created Filenumber " + fileno);
// }
// function createfiles(fileno){
//     let lines = Math.floor(Math.random() * 101);
//     let arr = [];
//     for(let i = 0 ; i < lines ; i++){
//         arr.push(Math.floor(Math.random() * 101));
//     }
//     let writeD = arr.join("\r\n");
//     fs.writeFile(fileno + ".txt",writeD,function(){
//         readfiles(fileno);
//     });
// }
// for(let i = 0 ; i < n ; i++){
//     createfiles(fileno);
//     fileno += 1 ;
// }
// let sum = 0 ;
// function readfiles(){
//     if(fileno > n){
//         return ;
//     }
//     let data = fs.readFileSync(fileno + ".txt", "utf-8");
//     let lines = data.split("\r\n");
//     for(let i = 0 ; i < lines.length ; i++){
//         sum += parseInt(lines[i]); 
//     }
//     console.log("you are reading" + fileno + ".txt");
//     fileno += 1 ;
//     readfiles();
// }
// readfiles();
// console.log("Sum is " + sum);
let promise = new Promise(function(resolve,reject ){
    if(fs.existsSync(n + ".txt")){
        console.log("HOLA");
        resolve("EXISTS");
    }
    else{
        reject("DOES NOT EXIST");
    }
});
function abc (val){
    console.log(val);
}
function error(err){
    console.log(err);
}
console.log(promise);
promise.then(abc).catch(error);
promise.then(function(val){
    console.log(val + " new callback");
})
