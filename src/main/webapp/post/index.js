       //===============下拉選單換字樣=============
        document.addEventListener("DOMContentLoaded", function () {
            var dropdownButton = document.getElementById("dropdownMenuButton1");
            var dropdownItems = document.querySelectorAll(".dropdown-item");

            dropdownItems.forEach(function (item) {
                item.addEventListener("click", function () {
                    var selectedText = item.innerText;
                    dropdownButton.innerText = selectedText;
                });
            });
        });

        //==============切換發文版型=================
        document.addEventListener("DOMContentLoaded", function () {
            var modal = new bootstrap.Modal(document.getElementById("exampleModal"));
            var discussionContent = document.getElementById("discussionContent");
            var gatheringContent = document.getElementById("gatheringContent");

            // 點擊選單切換內容
            document.getElementById("discuss1").addEventListener("click", function () {
//                console.log("討論版被點擊");
                // 關閉揪團版，顯示討論版
                gatheringContent.style.display = "none";
                discussionContent.style.display = "block";
            });

            document.getElementById("group").addEventListener("click", function () {
//                console.log("揪團版被點擊");
                // 關閉討論版，顯示揪團版
                discussionContent.style.display = "none";
                gatheringContent.style.display = "block";
            });

//            // 發布按鈕點擊時觸發
//            document.querySelector(".post-button").addEventListener("click", function () {
//                // 在這裡處理發布的邏輯
//                modal.hide();
//            });
        });

        //============上傳圖片跟預覽================
        window.addEventListener("load", function (e) {
            var preview_el = document.getElementById("preview");
            var p_file_el = document.getElementById("p_file");
            var preview_img = function (file) {

                var reader = new FileReader(); // 用來讀取檔案
                reader.readAsDataURL(file); // 讀取檔案
                reader.addEventListener("load", function () {
                    //console.log(reader.result);
                    /*
                    let img_node = document.createElement("img"); // <img>
                    img_node.setAttribute("src", reader.result); // <img src="base64">
                    img_node.setAttribute("class", "preview_img"); // <img src="base64" class="preview_img">
                    preview_el.innerHTML = '';
                    preview_el.append(img_node);
                    */

                    let img_str = '<img src="' + reader.result + '" class="preview_img">';
                    preview_el.innerHTML = img_str;
                });
            };


            p_file_el.addEventListener("change", function (e) {
                if (this.files.length > 0) {
                    preview_img(this.files[0]);
                } else {
                    preview_el.innerHTML = '<span class="text">預覽圖</span>';
                }
            });
        });

        window.addEventListener("load", function (e) {
            var preview_el = document.getElementById("preview2");
            var p_file_el = document.getElementById("p_file2");
            var preview_img = function (file) {

                var reader = new FileReader(); // 用來讀取檔案
                reader.readAsDataURL(file); // 讀取檔案
                reader.addEventListener("load", function () {
//                    console.log(reader.result);
                    /*
                    let img_node = document.createElement("img"); // <img>
                    img_node.setAttribute("src", reader.result); // <img src="base64">
                    img_node.setAttribute("class", "preview_img"); // <img src="base64" class="preview_img">
                    preview_el.innerHTML = '';
                    preview_el.append(img_node);
                    */

                    let img_str = '<img src="' + reader.result + '" class="preview_img">';
                    preview_el.innerHTML = img_str;
                });
            };


            p_file_el.addEventListener("change", function (e) {
                if (this.files.length > 0) {
                    preview_img(this.files[0]);
                } else {
                    preview_el.innerHTML = '<span class="text">預覽圖</span>';
                }
            });
        });

        window.addEventListener("load", function (e) {
            var preview_el = document.getElementById("preview_edit");
            var p_file_el = document.getElementById("p_file_edit");
            var preview_img = function (file) {

                var reader = new FileReader(); // 用來讀取檔案
                reader.readAsDataURL(file); // 讀取檔案
                reader.addEventListener("load", function () {
                    //console.log(reader.result);
                    /*
                    let img_node = document.createElement("img"); // <img>
                    img_node.setAttribute("src", reader.result); // <img src="base64">
                    img_node.setAttribute("class", "preview_img"); // <img src="base64" class="preview_img">
                    preview_el.innerHTML = '';
                    preview_el.append(img_node);
                    */

                    let img_str = '<img src="' + reader.result + '" class="preview_img">';
                    preview_el.innerHTML = img_str;
                });
            };


            p_file_el.addEventListener("change", function (e) {
                if (this.files.length > 0) {
                    preview_img(this.files[0]);
                } else {
                    preview_el.innerHTML = '<span class="text">預覽圖</span>';
                }
            });
        });
        
        window.addEventListener("load", function (e) {
            var preview_el = document.getElementById("preview2_edit");
            var p_file_el = document.getElementById("p_file2_edit");
            var preview_img = function (file) {

                var reader = new FileReader(); // 用來讀取檔案
                reader.readAsDataURL(file); // 讀取檔案
                reader.addEventListener("load", function () {
                    //console.log(reader.result);
                    /*
                    let img_node = document.createElement("img"); // <img>
                    img_node.setAttribute("src", reader.result); // <img src="base64">
                    img_node.setAttribute("class", "preview_img"); // <img src="base64" class="preview_img">
                    preview_el.innerHTML = '';
                    preview_el.append(img_node);
                    */

                    let img_str = '<img src="' + reader.result + '" class="preview_img">';
                    preview_el.innerHTML = img_str;
                });
            };


            p_file_el.addEventListener("change", function (e) {
                if (this.files.length > 0) {
                    preview_img(this.files[0]);
                } else {
                    preview_el.innerHTML = '<span class="text">預覽圖</span>';
                }
            });
        });
        
        