const puppeteer = require('puppeteer');
const id = "voyor68482@shzsedu.com";
const pass = "Ashu@421";
let users = ["nocidi6371","ralariv999","yasekin473","sibaje3329","pamahex943","kipavof852","kejavib309","mijora9576","bokej31440","fenemo4073"];



async function run () {
    const browser = await puppeteer.launch({
        headless: false,
        defaultViewport: false,
    });
    
    const page = await browser.newPage();
    await page.goto("https://www.hackerrank.com/auth/login");
    await page.waitForSelector("#input-1", {visible: true});
    await page.type("#input-1", id);
    await page.type("#input-2", pass);
    page.click(".ui-btn.ui-btn-large.ui-btn-primary.auth-button.ui-btn-styled");
    
    
        await page.waitForNavigation({waitUntil: "networkidle2"});
        await page.click(".dropdown-handle.nav_link.toggle-wrap");
        await page.click("a[data-analytics='NavBarProfileDropDownAdministration']");
    
        await page.waitForSelector("a[href='/administration/challenges']",{visible : true});
        await page.click("a[href='/administration/challenges']");
        await page.waitForSelector(".btn.btn-green.backbone.pull-right",{visible : true});
        let button = await page.$(".btn.btn-green.backbone.pull-right");
        let challengeurl = await page.evaluate(function(ele){
            return ele.getAttribute("href");
        },button);
        for(let i = 0; i < 5; i++){
            await challenge("https://www.hackerrank.com" + challengeurl,page);
        }

        
        await page.goto("https://image.shutterstock.com/image-vector/word-completed-isolated-on-white-260nw-340033517.jpg");
        console.log("-------------------------------------Process Completed-------------------------------------");
}
async function challenge(url,page){
    page.goto(url);
    await page.waitForSelector(".block.span12.profile-input",{visible : true});
    await page.type("#name", "hello");
    
    await page.type("#preview", "hello");        
    await page.waitForSelector('#problem_statement-container .CodeMirror textarea',{visible : true});
    await page.type('#problem_statement-container .CodeMirror textarea', 'challenge name');
    await page.waitForSelector('#input_format-container .CodeMirror textarea',{visible : true});
    await page.type('#input_format-container .CodeMirror textarea', 'challenge name');
    await page.waitForSelector('#constraints-container .CodeMirror textarea',{visible : true});
    await page.type('#constraints-container .CodeMirror textarea', 'challenge name');
    await page.waitForSelector('#output_format-container .CodeMirror textarea',{visible : true});
    await page.type('#output_format-container .CodeMirror textarea', 'challenge name');
    await page.waitForSelector('#tags_tag',{visible : true});
    await page.type('#tags_tag', 'challenge name');
    await page.keyboard.press("Enter");
    await page.click(".save-challenge.btn.btn-green");
    await page.waitForSelector("li[data-tab='moderators']",{visible : true});
    await page.click("li[data-tab='moderators']");

    
    for(let k = 0 ; k < users.length ; k++){
        await page.waitForSelector("#moderator",{visible : true});
        await page.type("#moderator", users[k]);
        await page.keyboard.press("Enter");
        await page.click(".save-challenge.btn.btn-green");
        
    }
}
run();
