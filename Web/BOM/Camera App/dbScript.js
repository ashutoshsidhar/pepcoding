let request = indexedDB.open("camera", 1);
let db;
request.onsuccess = function (e) {
    db = request.result;
}

request.onerror = function () {
    console.log("error");
}

request.onupgradeneeded = function (e) {
    db = request.result;
    db.createObjectStore("gallery", { keyPath: "nId" })
}

// for transaction
function addData(type, data) {
    let tx = db.transaction("gallery", "readwrite");
    let store = tx.objectStore("gallery");
    store.add({ nId: Date.now(), type: type, data: data });
}

function getData() {
    let tx = db.transaction("gallery", "readonly");
    let store = tx.objectStore("gallery");
    let req = store.openCursor();
    let gallery = document.querySelector(".gallery");
    req.onsuccess = function (e) {
        let cursor = req.result;     
        if (cursor) {
            if(cursor.value.type == "image") {
                let image = document.createElement("div");
                image.classList.add("image");
                image.innerHTML = `<img src='${cursor.value.data}'></img>`;
                gallery.append(image);
            } else {
                let videoUrl = URL.createObjectURL(cursor.value.data);
                let video = document.createElement("div");
                video.classList.add("video");
                video.innerHTML = `<video autoplay src='${videoUrl}' loop></video>`;
                gallery.append(video);
            }
            cursor.continue();
        } else {
            console.log("all data fetched")
        }

    }
}

