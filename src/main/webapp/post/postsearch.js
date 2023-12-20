$(document).ready(function() {
	//======顯示like狀態=======
	$("#post-list").on("click", "#commentcol", function() {
		var postID = $(this).attr("data-post-id");
		 setTimeout(function() {
		$.ajax({
			type: "POST",
			url: "http://localhost:8081/PiChill/forumlike/forumlike.do",
			data: {
				"action": "showlike",
				"postID": postID
			},
			dataType: "Json",
			success: function(postData) {
				console.log(postData.status);
					if (postData.status == true) {
							var $likeDiv = $(".likecol[data-post-id='" + postID + "'] .fa-thumbs-up");
									$likeDiv.css('color', 'blue');
								} 
			},
			error: function(xhr, status, error) {
				console.error("Get Post Details Error:", status, error);
			}
		});
  }, 300); 
	});
	//=======顯示完整文章==========
	$("#post-list").on("click", "#commentcol", function() {
		var postID = $(this).attr("data-post-id");
		$.ajax({
			type: "POST",
			url: "http://localhost:8081/PiChill/post/post.do",
			data: {
				"action": "get_By_postID",
				"postID": postID
			},
			dataType: "Json",
			success: function(postData) {
				var likeCol = $(`
                <div class="col-2 likecol" id="likecol" data-post-id="${postData.postID}">
                    <button type="button" class="fa-regular fa-thumbs-up likebutton"></button>
                     <span class="likecnt">${postData.likeCnt > 0 ? postData.likeCnt : ''}</span>
                </div>
            `);
            var commentCol = $(`
             <div class="col-2 commentcol" id="commentcol" data-post-id="${postData.postID}">
                    <button type="button" class="fa-regular fa-comment"></button>
                    <span class="commentcnt">${postData.commentCnt > 0 ? postData.commentCnt : ''}</span>
                    </div>`)
//				var commentCntSpan = $(`<span class="commentcnt">${postData.commentCnt > 0 ? postData.commentCnt : ''}</span>`);
				var formattedPostContent = postData.postContent.replace(/<br>/g, '\n');
				$("input.postType").val(postData.postType);
				$(".card-title.article0").text(postData.postTitle);
				$(".card-text.article1").text(formattedPostContent);
				$(".posttime").text(postData.postTime);
				$(".do").find(".likecol").replaceWith(likeCol);
				$(".do").find(".commentcol").replaceWith(commentCol);
//				$(".commentcol").html(`<i class="fa-regular fa-comment commentcol" data-post-id="${postData.postID}"></i> `).append(commentCntSpan);
				if (postData.postPic) {
					var postPic = postData.postPic;
					var imageDataArray = new Uint8Array(postPic);

					// 创建一个Blob对象并将其设置为<img>标签的src属性
					var blob = new Blob([imageDataArray], { type: 'image/jpeg' });
					var url = URL.createObjectURL(blob);
					$(".modal-image").attr("src", url);
				} else {
					$(".modal-image").attr('', url);
				}


			},
			error: function(xhr, status, error) {
				console.error("Get Post Details Error:", status, error);
			}
		});
	});
	$("#post-list").on("click", "#likecol", function() {
		var postID = $(this).attr("data-post-id");
		$.ajax({
			type: "POST",
			url: "http://localhost:8081/PiChill/post/post.do",
			data: {
				"action": "get_By_postID",
				"postID": postID
			},
			dataType: "Json",
			success: function(postData) {
				// 	        	console.log("aa")
				//				console.log(postData.postID)
				//				console.log(postData.likeCnt)
				var likeCol = $(`
                <div class="col-2 likecol" id="likecol" data-post-id="${postData.postID}">
                    <button type="button" class="fa-regular fa-thumbs-up likebutton"></button>
                     <span class="likecnt">${postData.likeCnt > 0 ? postData.likeCnt : ''}</span>
                </div>
            `);
				var formattedPostContent = postData.postContent.replace(/<br>/g, '\n');
				$("input.postType").val(postData.postType);
				$(".card-title.article0").text(postData.postTitle);
				$(".card-text.article1").text(formattedPostContent);
				$(".posttime").text(postData.postTime);
				$(".do").find(".likecol").replaceWith(likeCol);
				$(".commentcol").html(`<i class="fa-regular fa-comment"></i> ${postData.commentCnt}`);
				if (postData.postPic) {
					var postPic = postData.postPic;
					var imageDataArray = new Uint8Array(postPic);

					// 创建一个Blob对象并将其设置为<img>标签的src属性
					var blob = new Blob([imageDataArray], { type: 'image/jpeg' });
					var url = URL.createObjectURL(blob);
					$(".modal-image").attr("src", url);
				} else {
					$(".modal-image").attr('', url);
				}

			},
			error: function(xhr, status, error) {
				console.error("Get Post Details Error:", status, error);
			}
		});
	});
	// 	    //====我的文章=====
	$("#search-options").change(function() {
		var selectedOption = $(this).val();

		if (selectedOption === "my-posts") {
			$.ajax({
				type: "POST",
				url: "post.do",  // 替換成實際的後端處理檔案或API端點
				dataType: "json",
				data: {
					"action": "get_By_gUserID",
					"gUserID": 11000001  // 根據實際情況傳遞相應的用戶ID
				},
				success: function(data) {
					$("#post-list").empty();
					// 將伺服器返回的結果顯示在搜索結果區域
					//					console.log(data);
					var posts = data;

					for (var i = 0; i < posts.length; i++) {
						if (posts[i].postPic) {
							var postPic = posts[i].postPic;
							var imageDataArray = new Uint8Array(postPic);
							// 创建一个Blob对象并将其设置为<img>标签的src属性
							var blob = new Blob([imageDataArray], { type: 'image/jpeg' });
							var url = URL.createObjectURL(blob);
						} else {
							url = '';
						}
						var postType = posts[i].postType;
						var postID = posts[i].postID;
						var likeCnt = posts[i].likeCnt;
						var commentCnt = posts[i].commentCnt;
						if (postType === 0) {
							$("#post-list").append(`
                    		   <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
                               <div class="row g-0">
                                   <div class="col-md-8">
                                       <div class="card-body">
                                           <h1 class="modal-title fs-5">
                                               <img src="../image/cat.jpg" alt="大頭貼">
                                               <div>
                                                   <a class="post_user">貓貓</a>
                                                   <div class="post_time">${posts[i].postTime}</div>
                                               </div>
                                           </h1>
                                           <button type="button" class="edit_discuss" data-bs-toggle="modal" data-bs-target="#exampleModal_edit" data-post-id="${postID}">
                                           <i class="fa-regular fa-pen-to-square"></i>
                                               <span class="tooltip-text">編輯</span>
                                           </button>
                                           <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                                               <i class="fa-regular fa-trash-can"></i>
                                               <span class="tooltip-text">刪除</span>
                                           </button>
                                           <h5 class="card-title">${posts[i].postTitle}</h5>
                                           <p class="card-text">${posts[i].postContent}</p>
                                       </div>
                                   </div>
                                   <div class="col-md-4" id="piccontainer">
                                  <img src="${url}">
                               </div>
                                   <div class="container text-center">
                                       <div class="row align-items-start" id="card-footer" >
                                           <div class="col-2" id="likecol" data-post-id="${postID}">
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> ${posts[i].likeCnt > 0 ? posts[i].likeCnt : ''}</button>                                           </div>
                                           <div class="col-2" id="commentcol" data-post-id="${postID}">
                                           <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal"
                                               data-bs-target="#exampleModal5"> ${posts[i].commentCnt > 0 ? posts[i].commentCnt : ''}
                                           </div>
                                       </div>
                                   </div>
                               </div>
                           </div>
                           </div>
                       `);
						} else if (postType === 1) {
							$("#post-list").append(`
    	            	    <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
    	              <div class="row g-0">
    	                  <div class="col-md-8">
    	                      <div class="card-body">
    	                          <h1 class="modal-title fs-5" id="exampleModalLabel">
    	                              <img src="../image/dog.jpg" alt="大頭貼">
    	                              <div>
    	                                  <a class="post_user">小吉</a>
    	                                  <div class="post_time">${posts[i].postTime}</div>
    	                              </div>
    	                          </h1>
    	                            <button type="button" class="edit_group" data-bs-toggle="modal" data-bs-target="#exampleModal_edit2" data-post-id="${postID}">
                                          <i class="fa-regular fa-pen-to-square"></i>
                                              <span class="tooltip-text">編輯</span>
                                          </button>
                              <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                                  <i class="fa-regular fa-trash-can"></i>
                                  <span class="tooltip-text">刪除</span>
                              </button>

    	                          <h5 class="card-title">${posts[i].postTitle}</h5>
    	                          <div class="container text-left">
    	                              <div class="row">
    	                                  <div class="col-2 col-sm-2">日期:</div>
    	                                  <div class="col-2 col-sm-4">12/12</div>
    	                                  <div class="w-100 d-none d-md-block"></div>

    	                                  <div class="col-2 col-sm-2">時間:</div>
    	                                  <div class="col-2 col-sm-4">0800~0900</div>
    	                                  <div class="w-100 d-none d-md-block"></div>

    	                                  <div class="col-2 col-sm-2">地點:</div>
    	                                  <div class="col-2 col-sm-4">我家</div>
    	                                  <div class="w-100 d-none d-md-block"></div>

    	                                  <div class="col-2 col-sm-2">球類:</div>
    	                                  <div class="col-2 col-sm-4">保齡球</div>
    	                                  <div class="w-100 d-none d-md-block"></div>

    	                                  <div class="col-2 col-sm-2">費用:</div>
    	                                  <div class="col-2 col-sm-4">81000</div>
    	                              </div>
    	                          </div>
    	                          <p class="card-text2">${posts[i].postContent}</p>
    	                      </div>
    	                  </div>
    	                  <div class="col-md-4" id="piccontainer">
    	                  <img src="${url}">
    	              </div>
    	                  <div class="container text-center">
    	                      <div class="row align-items-start" id="card-footer">
    	                          <div class="col-2" id="likecol">
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal6"> ${post[i].likeCnt > 0 ? [post[i]].likeCnt : ''}</button>    	                          </div>
    	                          <div class="col-2" id="commentcol" data-post-id="${postID}">
    	                              <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal"
    	                                  data-bs-target="#exampleModal6" > ${posts[i].commentCnt > 0 ? posts[i].commentCnt : ''}
    	                              </div>
    	                          <div class="col-2" id="pluscol">
    	                              <button type="button" class="fa-regular fa-square-plus"> +1
    	                          </div>
    	                      </div>
    	                  </div>
    	              </div>
    	          </div>`
							);
						}
					}
				}
			});
		}
	});

	//=======文章類型搜尋==========
	var savedPostType;
	var posts;
	$("#search-options").change(function() {
		var selectedOption = $(this).val();
		$(".saved-post-type").val(selectedOption === "discussions" ? 0 : 1);
		savedPostType = $(".saved-post-type").val();
		console.log('Selected Option (Change Event):', selectedOption);
		if (selectedOption === "discussions" || selectedOption === "events") {
			$.ajax({
				type: "POST",
				url: "post.do",
				data: {
					"action": "get_By_Type",
					"postType": (selectedOption === "discussions") ? 0 : 1
				},
				success: function(data) {
					$(".saved-post-type").val(selectedOption === "discussions" ? 0 : 1);
					$("#post-list").empty();
					console.log(data);
					posts = data;

					for (var i = 0; i < posts.length; i++) {
							if (posts[i].postPic) {
							var postPic = posts[i].postPic;
							var imageDataArray = new Uint8Array(postPic);
							// 创建一个Blob对象并将其设置为<img>标签的src属性
							var blob = new Blob([imageDataArray], { type: 'image/jpeg' });
							var url = URL.createObjectURL(blob);
						} else {
							url = '';
						}
						var postType = posts[i].postType;
						var postID = posts[i].postID;
						var likeCnt = posts[i].likeCnt ? posts[i].likeCnt : '';
						var commentCnt = posts[i].commentCnt ? posts[i].commentCnt : '';
						if (selectedOption === "discussions") {
							// 生成討論版文章的HTML
							$("#post-list").append(`
                     		   <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
                     		  <input type="hidden" class="saved-post-type" value="" />
                                <div class="row g-0">
                                    <div class="col-md-8">
                                        <div class="card-body">
                                            <h1 class="modal-title fs-5">
                                                <img src="../image/cat.jpg" alt="大頭貼">
                                                <div>
                                                    <a class="post_user">貓貓</a>
                                                    <div class="post_time">${posts[i].postTime}</div>
                                                </div>
                                            </h1>
                                            <button type="button" class="edit_discuss" data-bs-toggle="modal" data-bs-target="#exampleModal_edit" data-post-id="${postID}">
                                            <i class="fa-regular fa-pen-to-square"></i>
                                                <span class="tooltip-text">編輯</span>
                                            </button>
                                            <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                                                <i class="fa-regular fa-trash-can"></i>
                                                <span class="tooltip-text">刪除</span>
                                            </button>
                                            <h5 class="card-title">${posts[i].postTitle}</h5>
                                            <p class="card-text">${posts[i].postContent}</p>
                                        </div>
                                    </div>
                                    <div class="col-md-4" id="piccontainer">
                                    <img src="${url}">
                                </div>
                                    <div class="container text-center">
                                        <div class="row align-items-start" id="card-footer">
                                            <div class="col-2" id="likecol" data-post-id="${postID}">
                                            <button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> ${posts[i].likeCnt > 0 ? posts[i].likeCnt : ''}</button>
                                            </div>
                                            <div class="col-2" id="commentcol" data-post-id="${postID}">
                                            <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal"
                                                data-bs-target="#exampleModal5" > ${posts[i].commentCnt > 0 ? posts[i].commentCnt : ''}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </div>
                        `);
						} else if (selectedOption === "events") {
							// 生成揪團版文章的HTML
							$("#post-list").append(`
                        	    <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
                        	    <input type="hidden" class="saved-post-type" value="" />
              	              <div class="row g-0">
              	                  <div class="col-md-8">
              	                      <div class="card-body">
              	                          <h1 class="modal-title fs-5" id="exampleModalLabel">
              	                              <img src="../image/dog.jpg" alt="大頭貼">
              	                              <div>
              	                                  <a class="post_user">小吉</a>
              	                                  <div class="post_time">${posts[i].postTime}</div>
              	                              </div>
              	                          </h1>
              	                           <button type="button" class="edit_group" data-bs-toggle="modal" data-bs-target="#exampleModal_edit2" data-post-id="${postID}">
                                          <i class="fa-regular fa-pen-to-square"></i>
                                              <span class="tooltip-text">編輯</span>
                                          </button>
                                        <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                                            <i class="fa-regular fa-trash-can"></i>
                                            <span class="tooltip-text">刪除</span>
                                        </button>

              	                          <h5 class="card-title">${posts[i].postTitle}</h5>
              	                          <div class="container text-left">
              	                              <div class="row">
              	                                  <div class="col-2 col-sm-2">日期:</div>
              	                                  <div class="col-2 col-sm-4">12/12</div>
              	                                  <div class="w-100 d-none d-md-block"></div>

              	                                  <div class="col-2 col-sm-2">時間:</div>
              	                                  <div class="col-2 col-sm-4">0800~0900</div>
              	                                  <div class="w-100 d-none d-md-block"></div>

              	                                  <div class="col-2 col-sm-2">地點:</div>
              	                                  <div class="col-2 col-sm-4">我家</div>
              	                                  <div class="w-100 d-none d-md-block"></div>

              	                                  <div class="col-2 col-sm-2">球類:</div>
              	                                  <div class="col-2 col-sm-4">保齡球</div>
              	                                  <div class="w-100 d-none d-md-block"></div>

              	                                  <div class="col-2 col-sm-2">費用:</div>
              	                                  <div class="col-2 col-sm-4">81000</div>
              	                              </div>
              	                          </div>
              	                          <p class="card-text2">${posts[i].postContent}</p>
              	                      </div>
              	                  </div>
              	                  <div class="col-md-4" id="piccontainer">
              	                  <img src="${url}">
              	              </div>
              	                  <div class="container text-center">
              	                      <div class="row align-items-start" id="card-footer">
              	                          <div class="col-2" id="likecol" data-post-id="${postID}">
                                            <button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal6"> ${posts[i].likeCnt > 0 ? posts[i].likeCnt : ''}</button>
              	                          </div>
              	                          <div class="col-2" id="commentcol" data-post-id="${postID}">
              	                              <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal"
              	                                  data-bs-target="#exampleModal6" > ${posts[i].commentCnt > 0 ? posts[i].commentCnt : ''}
              	                              </div>
              	                          <div class="col-2" id="pluscol">
              	                              <button type="button" class="fa-regular fa-square-plus"> +1
              	                          </div>
              	                      </div>
              	                  </div>
              	              </div>
              	          </div>
                        `);
						}
					}
				}
			});
		}
	});
	//======熱門=======

	$("#search-options").change(function() {
		var selectedOption = $(this).val();

		if (selectedOption === "hot") {

			$.ajax({
				type: "POST",
				url: "post.do",
				data: {
					"action": "get_By_Comment",
				},
				success: function(data) {
					$("#post-list").empty();

					console.log(data);
					var posts = data;

					for (var i = 0; i < posts.length; i++) {

							if (posts[i].postPic) {
							var postPic = posts[i].postPic;
							var imageDataArray = new Uint8Array(postPic);
							// 创建一个Blob对象并将其设置为<img>标签的src属性
							var blob = new Blob([imageDataArray], { type: 'image/jpeg' });
							var url = URL.createObjectURL(blob);
						} else {
							url = '';
						}
						var postType = posts[i].postType;
						var postID = posts[i].postID;
						var likeCnt = posts[i].likeCnt;
						var commentCnt = posts[i].commentCnt;
						if (postType === 0) {
							$("#post-list").append(`
                   		   <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
                              <div class="row g-0">
                                  <div class="col-md-8">
                                      <div class="card-body">
                                          <h1 class="modal-title fs-5">
                                              <img src="../image/cat.jpg" alt="大頭貼">
                                              <div>
                                                  <a class="post_user">貓貓</a>
                                                  <div class="post_time">${posts[i].postTime}</div>
                                              </div>
                                          </h1>
                                          <button type="button" class="edit_discuss" data-bs-toggle="modal" data-bs-target="#exampleModal_edit" data-post-id="${postID}">
                                          <i class="fa-regular fa-pen-to-square"></i>
                                              <span class="tooltip-text">編輯</span>
                                          </button>
                                          <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                                              <i class="fa-regular fa-trash-can"></i>
                                              <span class="tooltip-text">刪除</span>
                                          </button>
                                          <h5 class="card-title">${posts[i].postTitle}</h5>
                                          <p class="card-text">${posts[i].postContent}</p>
                                      </div>
                                  </div>
                                  <div class="col-md-4" id="piccontainer">
                                   <img src="${url}">
                              </div>
                                  <div class="container text-center">
                                      <div class="row align-items-start" id="card-footer">
                                          <div class="col-2" id="likecol" data-post-id="${postID}">
                                            <button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> ${posts[i].likeCnt > 0 ? posts[i].likeCnt : ''}</button>
                                          </div>
                                          <div class="col-2" id="commentcol" data-post-id="${postID}">
                                          <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal"
                                              data-bs-target="#exampleModal5" > ${posts[i].commentCnt > 0 ? posts[i].commentCnt : ''}
                                          </div>
                                      </div>
                                  </div>
                              </div>
                          </div>
                          </div>
                      `);
						} else if (postType === 1) {
							$("#post-list").append(`
   	            	    <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
   	              <div class="row g-0">
   	                  <div class="col-md-8">
   	                      <div class="card-body">
   	                          <h1 class="modal-title fs-5" id="exampleModalLabel">
   	                              <img src="../image/dog.jpg" alt="大頭貼">
   	                              <div>
   	                                  <a class="post_user">小吉</a>
   	                                  <div class="post_time">${posts[i].postTime}</div>
   	                              </div>
   	                          </h1>
   	                          <button type="button" class="edit_group" data-bs-toggle="modal" data-bs-target="#exampleModal_edit2" data-post-id="${postID}">
                                          <i class="fa-regular fa-pen-to-square"></i>
                                              <span class="tooltip-text">編輯</span>
                                          </button>
                             <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                                 <i class="fa-regular fa-trash-can"></i>
                                 <span class="tooltip-text">刪除</span>
                             </button>

   	                          <h5 class="card-title">${posts[i].postTitle}</h5>
   	                          <div class="container text-left">
   	                              <div class="row">
   	                                  <div class="col-2 col-sm-2">日期:</div>
   	                                  <div class="col-2 col-sm-4">12/12</div>
   	                                  <div class="w-100 d-none d-md-block"></div>

   	                                  <div class="col-2 col-sm-2">時間:</div>
   	                                  <div class="col-2 col-sm-4">0800~0900</div>
   	                                  <div class="w-100 d-none d-md-block"></div>

   	                                  <div class="col-2 col-sm-2">地點:</div>
   	                                  <div class="col-2 col-sm-4">我家</div>
   	                                  <div class="w-100 d-none d-md-block"></div>

   	                                  <div class="col-2 col-sm-2">球類:</div>
   	                                  <div class="col-2 col-sm-4">保齡球</div>
   	                                  <div class="w-100 d-none d-md-block"></div>

   	                                  <div class="col-2 col-sm-2">費用:</div>
   	                                  <div class="col-2 col-sm-4">81000</div>
   	                              </div>
   	                          </div>
   	                          <p class="card-text2">${posts[i].postContent}</p>
   	                      </div>
   	                  </div>
   	                  <div class="col-md-4" id="piccontainer">
   	                   <img src="${url}">
   	              </div>
   	                  <div class="container text-center">
   	                      <div class="row align-items-start" id="card-footer">
   	                          <div class="col-2" id="likecol" data-post-id="${postID}">
                                            <button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal6"> ${posts[i].likeCnt > 0 ? posts[i].likeCnt : ''}</button>
   	                          </div>
   	                          <div class="col-2" id="commentcol" data-post-id="${postID}">
   	                              <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal"
   	                                  data-bs-target="#exampleModal6" > ${posts[i].commentCnt > 0 ? posts[i].commentCnt : ''}
   	                              </div>
   	                          <div class="col-2" id="pluscol">
   	                              <button type="button" class="fa-regular fa-square-plus"> +1
   	                          </div>
   	                      </div>
   	                  </div>
   	              </div>
   	          </div>`
							);
						}
					}
				}
			});
		}
	});

	//=========標題搜尋==============//
	$("#search-button").click(function() {
		performSearch();
	});

	$("#search-input").keydown(function(event) {
		// 检查按下的键是否是 Enter 键 (key code 13)
		if (event.which === 13) {
			performSearch();
		}
	});
	function performSearch() {
		var postTitle = $("#search-input").val();
		var selectedOption = $("#search-options").val();
		$(".saved-post-type").val(selectedOption === "discussions" ? 0 : 1);
		savedPostType = $(".saved-post-type").val();
		console.log('Post Title:', postTitle);
		console.log('Selected Option:', selectedOption);
		console.log('Saved Post Type:', $(".saved-post-type").val());
		if (!postTitle.trim()) {
			alert("請輸入欲搜尋的標題");
			return; // 中止搜索操作
		}
		if (selectedOption === "discussions" || selectedOption === "events") {
			var filteredPosts = posts.filter(function(post) {
				return post.postTitle.includes(postTitle) && post.postType === (selectedOption === "discussions" ? 0 : 1);
			});
			displayPosts(filteredPosts);
		} else {
			$.ajax({
				type: "POST",
				url: "post.do",
				data: {
					"action": "get_By_Title",
					"postTitle": postTitle,
					"postType": savedPostType || (selectedOption === "discussions" ? 0 : 1)
				},
				success: function(data) {
					$(".saved-post-type").val(selectedOption);
					$("#post-list").empty();
					console.log(data);
					var filteredPosts = data;
					displayPosts(filteredPosts);
					var newUrl = "http://localhost:8081/PiChill/post/forum.html.html?q=" + encodeURIComponent(postTitle);
					history.pushState({ search: postTitle }, null, newUrl);
				}
			});
		}
	}
	function displayPosts(postsToDisplay) {
		$("#post-list").empty();
		for (var i = 0; i < postsToDisplay.length; i++) {
			var post = postsToDisplay[i];
				if (post.postPic) {
							var postPic = post.postPic;
							var imageDataArray = new Uint8Array(postPic);
							// 创建一个Blob对象并将其设置为<img>标签的src属性
							var blob = new Blob([imageDataArray], { type: 'image/jpeg' });
							var url = URL.createObjectURL(blob);
						} else {
							url = '';
						}
			var postType = post.postType;
			var postTime = post.postTime;
			var postID = post.postID;
			var likeCnt = post.likeCnt;
			var commentCnt = post.commentCnt;
			if (postType === 0) {
				$("#post-list").append(`
                		   <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
                		   <input type="hidden" class="saved-post-type" value="" />
                           <div class="row g-0">
                               <div class="col-md-8">
                                   <div class="card-body">
                                       <h1 class="modal-title fs-5">
                                           <img src="../image/cat.jpg" alt="大頭貼">
                                           <div>
                                               <a class="post_user">貓貓</a>
                                               <div class="post_time">${postTime}</div>
                                           </div>
                                       </h1>
                                       <button type="button" class="edit_discuss" data-bs-toggle="modal" data-bs-target="#exampleModal_edit" data-post-id="${postID}">
                                       <i class="fa-regular fa-pen-to-square"></i>
                                           <span class="tooltip-text">編輯</span>
                                       </button>
                                       <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                                           <i class="fa-regular fa-trash-can"></i>
                                           <span class="tooltip-text">刪除</span>
                                       </button>
                                       <h5 class="card-title">${post.postTitle}</h5>
                                       <p class="card-text">${post.postContent}</p>
                                   </div>
                               </div>
                               <div class="col-md-4" id="piccontainer">
                                <img src="${url}">
                           </div>
                               <div class="container text-center">
                                   <div class="row align-items-start" id="card-footer">
                                       <div class="col-2" id="likecol" data-post-id="${postID}">
                                            <button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> ${likeCnt > 0 ? likeCnt : ''}</button>
                                       </div>
                                       <div class="col-2" id="commentcol" data-post-id="${postID}">
                                       <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal"
                                           data-bs-target="#exampleModal5" > ${commentCnt > 0 ? commentCnt : ''}
                                       </div>
                                   </div>
                               </div>
                           </div>
                       </div>
                       </div>
                   `);
			} else if (postType === 1) {
				$("#post-list").append(`
	            	    <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
	            	    <input type="hidden" class="saved-post-type" value="" />
	              <div class="row g-0">
	                  <div class="col-md-8">
	                      <div class="card-body">
	                          <h1 class="modal-title fs-5" id="exampleModalLabel">
	                              <img src="../image/dog.jpg" alt="大頭貼">
	                              <div>
	                                  <a class="post_user">小吉</a>
	                                  <div class="post_time">${postTime}</div>
	                              </div>
	                          </h1>
	                          <button type="button" class="edit_group" data-bs-toggle="modal" data-bs-target="#exampleModal_edit2" data-post-id="${postID}">
                                          <i class="fa-regular fa-pen-to-square"></i>
                                              <span class="tooltip-text">編輯</span>
                                          </button>
                          <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                              <i class="fa-regular fa-trash-can"></i>
                              <span class="tooltip-text">刪除</span>
                          </button>

	                          <h5 class="card-title">${post.postTitle}</h5>
	                          <div class="container text-left">
	                              <div class="row">
	                                  <div class="col-2 col-sm-2">日期:</div>
	                                  <div class="col-2 col-sm-4">12/12</div>
	                                  <div class="w-100 d-none d-md-block"></div>

	                                  <div class="col-2 col-sm-2">時間:</div>
	                                  <div class="col-2 col-sm-4">0800~0900</div>
	                                  <div class="w-100 d-none d-md-block"></div>

	                                  <div class="col-2 col-sm-2">地點:</div>
	                                  <div class="col-2 col-sm-4">我家</div>
	                                  <div class="w-100 d-none d-md-block"></div>

	                                  <div class="col-2 col-sm-2">球類:</div>
	                                  <div class="col-2 col-sm-4">保齡球</div>
	                                  <div class="w-100 d-none d-md-block"></div>

	                                  <div class="col-2 col-sm-2">費用:</div>
	                                  <div class="col-2 col-sm-4">81000</div>
	                              </div>
	                          </div>
	                          <p class="card-text2">${post.postContent}</p>
	                      </div>
	                  </div>
	                  <div class="col-md-4" id="piccontainer">
	                   <img src="${url}">
	              </div>
	                  <div class="container text-center">
	                      <div class="row align-items-start" id="card-footer">
	                          <div class="col-2" id="likecol" data-post-id="${postID}">
                                            <button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal6"> ${likeCnt > 0 ? likeCnt : ''}</button>
	                          </div>
	                          <div class="col-2" id="commentcol" data-post-id="${postID}">
	                              <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal"
	                                  data-bs-target="#exampleModal6" > ${commentCnt > 0 ? commentCnt : ''}
	                              </div>
	                          <div class="col-2" id="pluscol">
	                              <button type="button" class="fa-regular fa-square-plus"> +1
	                          </div>
	                      </div>
	                  </div>
	              </div>
	          </div>`
				);
			}
		}
	}
});