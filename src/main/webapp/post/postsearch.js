$(document).ready(function() {
	//======顯示like狀態=======
	$("#post-list").on("click", "#commentcol", function() {
		var postID = $(this).attr("data-post-id");
		var gUserID = $("#userID").val();
		if (gUserID !== "null" && gUserID !== undefined && gUserID !== "") {
			setTimeout(function() {
				$.ajax({
					type: "POST",
					url: "http://localhost:8081/PiChill/forumlike/forumlike.do",
					data: {
						"action": "showlike",
						"postID": postID,
						"gUserID": gUserID
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
		}
	});
	//=======顯示完整文章==========
	$('#exampleModal6').on('hide.bs.modal', function() {
		var currentURL = "http://localhost:8081/PiChill/post/forum.html";
		history.replaceState({}, "", currentURL);
	});
	$('#exampleModal5').on('hide.bs.modal', function() {
		var currentURL = "http://localhost:8081/PiChill/post/forum.html";
		history.replaceState({}, "", currentURL);
	});
	function loadPostContent(postID) {
		$.ajax({
			type: "POST",
			url: "post.do",
			data: {
				"action": "get_By_postID",
				"postID": postID
			},
			dataType: "Json",
			success: function(postData) {
				var likeCol = $(`
                <div class="col-2 likecol" id="likecol" data-post-id="${postData.addedPost.postID}">
                    <button type="button" class="fa-regular fa-thumbs-up likebutton"></button>
                     <span class="likecnt">${postData.addedPost.likeCnt > 0 ? postData.addedPost.likeCnt : ''}</span>
                </div>
            `);
				var commentCol = $(`
             <div class="col-2 commentcol" id="commentcol" data-post-id="${postData.addedPost.postID}">
                    <button type="button" class="fa-regular fa-comment"></button>
                    <span class="commentcnt">${postData.addedPost.commentCnt > 0 ? postData.addedPost.commentCnt : ''}</span>
                    </div>`)
				//				var commentCntSpan = $(`<span class="commentcnt">${postData.commentCnt > 0 ? postData.commentCnt : ''}</span>`);
				var formattedPostContent = postData.addedPost.postContent.replace(/<br>/g, '\n');


				// 設置貓貓元素的文本為nicknameID
				$(".post_user2").text(postData.generalUser.nicknameID);
				$("input.postType").val(postData.addedPost.postType);
				$(".card-title.article0").text(postData.addedPost.postTitle);
				$(".card-text.article1").text(formattedPostContent);
				$(".posttime").text(postData.addedPost.postTime);
				if (postData.addedPost.postType == 1) {
					$(".dateRO").text(postData.reserveOrder.reserveDate);
					$(".timeRO").text(postData.reserveOrder.time);
					$(".locRO").text(postData.reserveOrder.courtName);
					var ballText = '';
					if (postData.reserveOrder.ball === 0) {
						ballText = "籃球";
					} else if (postData.reserveOrder.ball === 1) {
						ballText = "排球";
					} else if (postData.reserveOrder.ball === 2) {
						ballText = "羽球";
					}
					$(".ballRO").text(ballText);
					$(".feeRO").text(postData.reserveOrder.fee);
				}
				$(".do").find(".likecol").replaceWith(likeCol);
				$(".do").find(".commentcol").replaceWith(commentCol);
				//				$(".commentcol").html(`<i class="fa-regular fa-comment commentcol" data-post-id="${postData.postID}"></i> `).append(commentCntSpan);
				if (postData.addedPost.postPic) {
					var postPic = postData.addedPost.postPic;
					var imageDataArray = new Uint8Array(postPic);

					// 创建一个Blob对象并将其设置为<img>标签的src属性
					var blob = new Blob([imageDataArray], { type: 'image/jpeg' });
					var url = URL.createObjectURL(blob);
					$(".modal-image").attr("src", url);
				} else {
					$(".modal-image").attr('', url);
				}
				if (postData.generalUser.gProfilePic) {
					var imageDataArray2 = new Uint8Array(postData.generalUser.gProfilePic);
					// 将二进制图像数据存储在Blob对象中
					var blob2 = new Blob([imageDataArray2], { type: 'image/jpeg' });
					// 创建一个Blob URL并将其设置为<img>标签的src属性
					var url2 = URL.createObjectURL(blob2);
					$("#profilePic").attr("src", url2);
				}
				if (postData.generalUser.gProfilePic) {
					var imageDataArray2 = new Uint8Array(postData.generalUser.gProfilePic);
					// 将二进制图像数据存储在Blob对象中
					var blob2 = new Blob([imageDataArray2], { type: 'image/jpeg' });
					// 创建一个Blob URL并将其设置为<img>标签的src属性
					var url2 = URL.createObjectURL(blob2);
					$("#profilePic2").attr("src", url2);
				}

			},
			error: function(xhr, status, error) {
				console.error("Get Post Details Error:", status, error);
			}
		});
	}
	$("#post-list").on("click", "#commentcol", function() {
		var postID = $(this).attr("data-post-id");
		var currentURL = "http://localhost:8081/PiChill/post/forum.html";
		var newURL = currentURL + "?postID=" + postID;
		history.pushState({}, "", newURL);
		loadPostContent(postID);
	})
	//=======外部點擊連結顯示文章=========
	$(document).ready(function() {
		var urlParams = new URLSearchParams(window.location.search);
		var postID = urlParams.get("postID");
		if (postID) {
			$('#exampleModal6').modal('show');
			loadPostContent(postID);
		}
	})
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
				var likeCol = $(`
                <div class="col-2 likecol" id="likecol" data-post-id="${postData.addedPost.postID}">
                    <button type="button" class="fa-regular fa-thumbs-up likebutton"></button>
                     <span class="likecnt">${postData.addedPost.likeCnt > 0 ? postData.addedPost.likeCnt : ''}</span>
                </div>
            `);
				var commentCol = $(`
             <div class="col-2 commentcol" id="commentcol" data-post-id="${postData.addedPost.postID}">
                    <button type="button" class="fa-regular fa-comment"></button>
                    <span class="commentcnt">${postData.addedPost.commentCnt > 0 ? postData.addedPost.commentCnt : ''}</span>
                    </div>`)
				//				var commentCntSpan = $(`<span class="commentcnt">${postData.commentCnt > 0 ? postData.commentCnt : ''}</span>`);
				var formattedPostContent = postData.addedPost.postContent.replace(/<br>/g, '\n');


				// 設置貓貓元素的文本為nicknameID
				$(".post_user2").text(postData.generalUser.nicknameID);
				$("input.postType").val(postData.addedPost.postType);
				$(".card-title.article0").text(postData.addedPost.postTitle);
				$(".card-text.article1").text(formattedPostContent);
				$(".posttime").text(postData.addedPost.postTime);
				if (postData.addedPost.postType == 1) {
					$(".dateRO").text(postData.reserveOrder.reserveDate);
					$(".timeRO").text(postData.reserveOrder.time);
					$(".locRO").text(postData.reserveOrder.courtName);
					var ballText = '';
					if (postData.reserveOrder.ball === 0) {
						ballText = "籃球";
					} else if (postData.reserveOrder.ball === 1) {
						ballText = "排球";
					} else if (postData.reserveOrder.ball === 2) {
						ballText = "羽球";
					}
					$(".ballRO").text(ballText);
					$(".feeRO").text(postData.reserveOrder.fee);
				}

				$(".do").find(".likecol").replaceWith(likeCol);
				$(".do").find(".commentcol").replaceWith(commentCol);
				//				$(".commentcol").html(`<i class="fa-regular fa-comment commentcol" data-post-id="${postData.postID}"></i> `).append(commentCntSpan);
				if (postData.addedPost.postPic) {
					var postPic = postData.addedPost.postPic;
					var imageDataArray = new Uint8Array(postPic);

					// 创建一个Blob对象并将其设置为<img>标签的src属性
					var blob = new Blob([imageDataArray], { type: 'image/jpeg' });
					var url = URL.createObjectURL(blob);
					$(".modal-image").attr("src", url);
				} else {
					$(".modal-image").attr('', url);
				}
				if (postData.generalUser.gProfilePic) {
					var imageDataArray2 = new Uint8Array(postData.generalUser.gProfilePic);
					// 将二进制图像数据存储在Blob对象中
					var blob2 = new Blob([imageDataArray2], { type: 'image/jpeg' });
					// 创建一个Blob URL并将其设置为<img>标签的src属性
					var url2 = URL.createObjectURL(blob2);
					$("#profilePic").attr("src", url2);
				}
				if (postData.generalUser.gProfilePic) {
					var imageDataArray2 = new Uint8Array(postData.generalUser.gProfilePic);
					// 将二进制图像数据存储在Blob对象中
					var blob2 = new Blob([imageDataArray2], { type: 'image/jpeg' });
					// 创建一个Blob URL并将其设置为<img>标签的src属性
					var url2 = URL.createObjectURL(blob2);
					$("#profilePic2").attr("src", url2);
				}

			},
			error: function(xhr, status, error) {
				console.error("Get Post Details Error:", status, error);
			}
		});
	});
	// 	    //====我的文章=====
	$("#search-options").change(function() {
		var gUserID = $("#userID").val();
		var selectedOption = $(this).val();
		if (selectedOption === "my-posts") {
			$.ajax({
				type: "POST",
				url: "post.do",  // 替換成實際的後端處理檔案或API端點
				dataType: "json",
				data: {
					"action": "get_By_gUserID",
					"gUserID": gUserID  // 根據實際情況傳遞相應的用戶ID
				},
				success: function(data) {
					$("#post-list").empty();
					// 將伺服器返回的結果顯示在搜索結果區域
					//					console.log(data);
					//					console.log("進來了")
					var posts = data.posts;
					var roDataList = data.ro; // 获取 ReserveOrder 数据

					// 循环处理每个 ReserveOrder 数据
					for (var i = 0; i < roDataList.length; i++) {
						var reserveOrderData = roDataList[i];
						var courtName = reserveOrderData.courtName;
						var ball = reserveOrderData.ball;
						var ballText = '';
						if (ball === 0) {
							ballText = "籃球";
						} else if (ball === 1) {
							ballText = "排球";
						} else if (ball === 2) {
							ballText = "羽球";
						}
						var placeFee = reserveOrderData.placeFee;
						var reserveTime = reserveOrderData.reserveTime;
						var reserveDate = reserveOrderData.reserveDate;

						// 在此处使用这些值，例如将它们添加到DOM元素中
					}
					var currentUserId = $('#userID').val();
					var gUserID = data.gUser.gUserID;
					var nicknameID = data.gUser.nicknameID;
					//					console.log(nicknameID);
					var gProfilePic = data.gUser.gProfilePic;
					if (gProfilePic) {
						var imageDataArray2 = new Uint8Array(gProfilePic);
						// 将二进制图像数据存储在Blob对象中
						var blob2 = new Blob([imageDataArray2], { type: 'image/jpeg' });
						// 创建一个Blob URL并将其设置为<img>标签的src属性
						var url2 = URL.createObjectURL(blob2);
					}
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
                                               <img src="${url2}" alt="大頭貼">
                                               <div>
                                                   <a class="post_user">${nicknameID}</a>
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
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> </button>
<span class="likecnt">  ${posts[i].likeCnt > 0 ? posts[i].likeCnt : ''}</span>
                            </div>
                                           <div class="col-2" id="commentcol" data-post-id="${postID}">
                    <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal" data-bs-target="#exampleModal5"></button>
                     <span class="commentcnt">${posts[i].commentCnt > 0 ? posts[i].commentCnt : ''}</span>
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
    	                              <img src="${url2}" alt="大頭貼">
    	                              <div>
    	                                  <a class="post_user">${nicknameID}</a>
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
    	                                  <div class="col-2 col-sm-4">${reserveDate}</div>
    	                                  <div class="w-100 d-none d-md-block"></div>

    	                                  <div class="col-2 col-sm-2">時間:</div>
    	                                  <div class="col-2 col-sm-4">${reserveTime}</div>
    	                                  <div class="w-100 d-none d-md-block"></div>

    	                                  <div class="col-2 col-sm-2">地點:</div>
    	                                  <div class="col-2 col-sm-5">${courtName}</div>
    	                                  <div class="w-100 d-none d-md-block"></div>

    	                                  <div class="col-2 col-sm-2">球類:</div>
    	                                  <div class="col-2 col-sm-4">${ballText}</div>
    	                                  <div class="w-100 d-none d-md-block"></div>

    	                                  <div class="col-2 col-sm-2">費用:</div>
    	                                  <div class="col-2 col-sm-4">${placeFee}元</div>
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
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> </button>
<span class="likecnt">  ${posts[i].likeCnt > 0 ? posts[i].likeCnt : ''}</span>
                            </div>
    	                           <div class="col-2" id="commentcol" data-post-id="${postID}">
                    <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal" data-bs-target="#exampleModal5"></button>
                     <span class="commentcnt">${posts[i].commentCnt > 0 ? posts[i].commentCnt : ''}</span>
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
				}, error: function(xhr, status, error) {
					console.error('AJAX请求失败:', error);
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
		//		console.log('Selected Option (Change Event):', selectedOption);
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
					var currentUserId = $('#userID').val();
					//					console.log(data);
					var combinedList = data; // 假设您的数据是一个包含post和generalUser的数组
					//					console.log(data);
					for (var i = 0; i < combinedList.length; i++) {
						var post = combinedList[i].post;
						var generalUser = combinedList[i].generalUser;
						var courtName = combinedList[i].courtName;
						var ball = combinedList[i].ball;
						var placeFee = combinedList[i].placeFee;
						var reserveTime = combinedList[i].reserveTime;
						var reserveDate = combinedList[i].reserveDate;
						var ballText = '';
						if (ball === 0) {
							ballText = "籃球";
						} else if (ball === 1) {
							ballText = "排球";
						} else if (ball === 2) {
							ballText = "羽球";
						}

						// 这里可以访问generalUser数据，例如generalUser.gUserID、generalUser.nicknameID等
						var gUserID = generalUser.gUserID;
						var nicknameID = generalUser.nicknameID;
						var gProfilePic = generalUser.gProfilePic;
						if (gProfilePic) {
							var imageDataArray2 = new Uint8Array(gProfilePic);
							// 将二进制图像数据存储在Blob对象中
							var blob2 = new Blob([imageDataArray2], { type: 'image/jpeg' });
							// 创建一个Blob URL并将其设置为<img>标签的src属性
							var url2 = URL.createObjectURL(blob2);
						}
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
						var postID = post.postID;
						var likeCnt = post.likeCnt ? post.likeCnt : '';
						var commentCnt = post.commentCnt ? post.commentCnt : '';

						if (selectedOption === "discussions") {
							// 生成討論版文章的HTML
							$("#post-list").append(`
                     		   <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
                     		  <input type="hidden" class="saved-post-type" value="" />
                                <div class="row g-0">
                                    <div class="col-md-8">
                                    <input type="hidden" id="${gUserID}" >
                                        <div class="card-body">
                                            <h1 class="modal-title fs-5">
                                                <img src=${url2} alt="大頭貼">
                                                <div>
                                                    <a class="post_user">${nicknameID}</a>
                                                    <div class="post_time">${post.postTime}</div>
                                                </div>
                                            </h1>
                                            <button type="button" class="edit_discuss" data-bs-toggle="modal" data-bs-target="#exampleModal_edit" id="editButton" data-post-id="${postID}">
                                            <i class="fa-regular fa-pen-to-square"></i>
                                                <span class="tooltip-text">編輯</span>
                                            </button>
                                            <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                                                <i class="fa-regular fa-trash-can"></i>
                                                <span class="tooltip-text">刪除</span>
                                            </button>
                                                  <button type="button" class="report" data-bs-toggle="modal" data-bs-target="#exampleModal10" id="reportButton" data-post-id="${postID}">
                                <i class="fa-solid fa-triangle-exclamation"></i>
                                <span class="tooltip-text">檢舉</span>    
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
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> </button>
<span class="likecnt"> ${likeCnt > 0 ? likeCnt : ''}</span>
                            </div>
                                           <div class="col-2" id="commentcol" data-post-id="${postID}">
                    <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal" data-bs-target="#exampleModal5"></button>
                     <span class="commentcnt"> ${commentCnt > 0 ? commentCnt : ''}</span>
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
              	                  <input type="hidden" id="${gUserID}" >
              	                      <div class="card-body">
              	                          <h1 class="modal-title fs-5" id="exampleModalLabel">
              	                              <img src=${url2} alt="大頭貼">
              	                              <div>
              	                                  <a class="post_user">${nicknameID}</a>
              	                                  <div class="post_time">${post.postTime}</div>
              	                              </div>
              	                          </h1>
              	                           <button type="button" class="edit_group" data-bs-toggle="modal" data-bs-target="#exampleModal_edit2" id="editButton" data-post-id="${postID}">
                                          <i class="fa-regular fa-pen-to-square"></i>
                                              <span class="tooltip-text">編輯</span>
                                          </button>
                                        <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                                            <i class="fa-regular fa-trash-can"></i>
                                            <span class="tooltip-text">刪除</span>
                                        </button>
<button type="button" class="report" data-bs-toggle="modal" data-bs-target="#exampleModal10" id="reportButton" data-post-id="${postID}">
                                <i class="fa-solid fa-triangle-exclamation"></i>
                                <span class="tooltip-text">檢舉</span>    
                            </button>
              	                          <h5 class="card-title">${post.postTitle}</h5>
              	                          <div class="container text-left">
              	                              <div class="row">
              	                                  <div class="col-2 col-sm-2">日期:</div>
              	                                  <div class="col-2 col-sm-4">${reserveDate}</div>
              	                                  <div class="w-100 d-none d-md-block"></div>

              	                                  <div class="col-2 col-sm-2">時間:</div>
              	                                  <div class="col-2 col-sm-4">${reserveTime}</div>
              	                                  <div class="w-100 d-none d-md-block"></div>

              	                                  <div class="col-2 col-sm-2">地點:</div>
              	                                  <div class="col-2 col-sm-5">${courtName}</div>
              	                                  <div class="w-100 d-none d-md-block"></div>

              	                                  <div class="col-2 col-sm-2">球類:</div>
              	                                  <div class="col-2 col-sm-4">${ballText}</div>
              	                                  <div class="w-100 d-none d-md-block"></div>

              	                                  <div class="col-2 col-sm-2">費用:</div>
              	                                  <div class="col-2 col-sm-4">${placeFee}</div>
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
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> </button>
<span class="likecnt"> ${likeCnt > 0 ? likeCnt : ''}</span>
                            </div>
              	                          <div class="col-2" id="commentcol" data-post-id="${postID}">
                    <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal" data-bs-target="#exampleModal5"></button>
                     <span class="commentcnt"> ${commentCnt > 0 ? commentCnt : ''}</span>
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
						if (currentUserId == gUserID) {
							$('#reportButton[data-post-id="' + postID + '"]').hide();
						} else {
							//			console.log('Hiding buttons');
							$('#editButton[data-post-id="' + postID + '"]').hide();
							$('#deleteButton[data-post-id="' + postID + '"]').hide();
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
				dataType: "json",
				success: function(data) {
					$("#post-list").empty();

					var currentUserId = $('#userID').val();
					//					console.log(data);
					var combinedList = data; // 假设您的数据是一个包含post和generalUser的数组
					for (var i = 0; i < combinedList.length; i++) {
						var post = combinedList[i].post;
						var generalUser = combinedList[i].generalUser;
						var courtName = combinedList[i].courtName;
						var ball = combinedList[i].ball;
						var placeFee = combinedList[i].placeFee;
						var reserveTime = combinedList[i].reserveTime;
						var reserveDate = combinedList[i].reserveDate;
						var ballText = '';
						if (ball === 0) {
							ballText = "籃球";
						} else if (ball === 1) {
							ballText = "排球";
						} else if (ball === 2) {
							ballText = "羽球";
						}
						// 这里可以访问generalUser数据，例如generalUser.gUserID、generalUser.nicknameID等
						var gUserID = generalUser.gUserID;
						var nicknameID = generalUser.nicknameID;
						var gProfilePic = generalUser.gProfilePic;
						if (gProfilePic) {
							var imageDataArray2 = new Uint8Array(gProfilePic);
							// 将二进制图像数据存储在Blob对象中
							var blob2 = new Blob([imageDataArray2], { type: 'image/jpeg' });
							// 创建一个Blob URL并将其设置为<img>标签的src属性
							var url2 = URL.createObjectURL(blob2);
						}
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
						var postID = post.postID;
						var likeCnt = post.likeCnt ? post.likeCnt : '';
						var commentCnt = post.commentCnt ? post.commentCnt : '';
						if (postType === 0) {
							$("#post-list").append(`
                   		   <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
                              <div class="row g-0">
                                  <div class="col-md-8">
                                  <input type="hidden" id="${gUserID}" >
                                      <div class="card-body">
                                          <h1 class="modal-title fs-5">
                                              <img src=${url2} alt="大頭貼">
                                              <div>
                                                  <a class="post_user">${nicknameID}</a>
                                                  <div class="post_time">${post.postTime}</div>
                                              </div>
                                          </h1>
                                          <button type="button" class="edit_discuss" data-bs-toggle="modal" data-bs-target="#exampleModal_edit" id="editButton" data-post-id="${postID}">
                                          <i class="fa-regular fa-pen-to-square"></i>
                                              <span class="tooltip-text">編輯</span>
                                          </button>
                                          <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                                              <i class="fa-regular fa-trash-can"></i>
                                              <span class="tooltip-text">刪除</span>
                                          </button>
                                          <button type="button" class="report" data-bs-toggle="modal" data-bs-target="#exampleModal10" id="reportButton" data-post-id="${postID}">
                                <i class="fa-solid fa-triangle-exclamation"></i>
                                <span class="tooltip-text">檢舉</span>    
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
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> </button>
<span class="likecnt"> ${likeCnt > 0 ? likeCnt : ''}</span>
                            </div>
                                          <div class="col-2" id="commentcol" data-post-id="${postID}">
                    <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal" data-bs-target="#exampleModal5"></button>
                     <span class="commentcnt"> ${commentCnt > 0 ? commentCnt : ''}</span>
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
   	                  <input type="hidden" id="${gUserID}" >
   	                      <div class="card-body">
   	                          <h1 class="modal-title fs-5" id="exampleModalLabel">
   	                              <img src=${url2} alt="大頭貼">
   	                              <div>
   	                                  <a class="post_user">${nicknameID}</a>
   	                                  <div class="post_time">${post.postTime}</div>
   	                              </div>
   	                          </h1>
   	                          <button type="button" class="edit_group" data-bs-toggle="modal" data-bs-target="#exampleModal_edit2" id="editButton" data-post-id="${postID}">
                                          <i class="fa-regular fa-pen-to-square"></i>
                                              <span class="tooltip-text">編輯</span>
                                          </button>
                             <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                                 <i class="fa-regular fa-trash-can"></i>
                                 <span class="tooltip-text">刪除</span>
                             </button>
                             <button type="button" class="report" data-bs-toggle="modal" data-bs-target="#exampleModal10" id="reportButton" data-post-id="${postID}">
                                <i class="fa-solid fa-triangle-exclamation"></i>
                                <span class="tooltip-text">檢舉</span>    
                            </button>
   	                          <h5 class="card-title">${post.postTitle}</h5>
   	                          <div class="container text-left">
   	                              <div class="row">
   	                                  <div class="col-2 col-sm-2">日期:</div>
   	                                  <div class="col-2 col-sm-4">${reserveDate}</div>
   	                                  <div class="w-100 d-none d-md-block"></div>

   	                                  <div class="col-2 col-sm-2">時間:</div>
   	                                  <div class="col-2 col-sm-4">${reserveTime}</div>
   	                                  <div class="w-100 d-none d-md-block"></div>

   	                                  <div class="col-2 col-sm-2">地點:</div>
   	                                  <div class="col-2 col-sm-5">${courtName}</div>
   	                                  <div class="w-100 d-none d-md-block"></div>

   	                                  <div class="col-2 col-sm-2">球類:</div>
   	                                  <div class="col-2 col-sm-4">${ballText}</div>
   	                                  <div class="w-100 d-none d-md-block"></div>

   	                                  <div class="col-2 col-sm-2">費用:</div>
   	                                  <div class="col-2 col-sm-4">${placeFee}</div>
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
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> </button>
<span class="likecnt"> ${likeCnt > 0 ? likeCnt : ''}</span>
                            </div>
   	                          <div class="col-2" id="commentcol" data-post-id="${postID}">
                    <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal" data-bs-target="#exampleModal5"></button>
                     <span class="commentcnt"> ${commentCnt > 0 ? commentCnt : ''}</span>
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
						if (currentUserId == gUserID) {
							$('#reportButton[data-post-id="' + postID + '"]').hide();
						} else {
							//			console.log('Hiding buttons');
							$('#editButton[data-post-id="' + postID + '"]').hide();
							$('#deleteButton[data-post-id="' + postID + '"]').hide();
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
		//		console.log('Post Title:', postTitle);
		//		console.log('Selected Option:', selectedOption);
		//		console.log('Saved Post Type:', $(".saved-post-type").val());
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
					//					console.log(data);
					var filteredPosts = data;
					displayPosts(filteredPosts);
					//					var newUrl = "http://localhost:8081/PiChill/post/forum.html.html?q=" + encodeURIComponent(postTitle);
					//					history.pushState({ search: postTitle }, null, newUrl);
				}
			});
		}
	}
	function displayPosts(postsToDisplay) {
		$("#post-list").empty();
		var currentUserId = $('#userID').val();
		//					console.log(data);
		var combinedList = postsToDisplay; // 假设您的数据是一个包含post和generalUser的数组
		for (var i = 0; i < combinedList.length; i++) {
			var post = combinedList[i].post;
			var generalUser = combinedList[i].generalUser;
			var courtName = combinedList[i].courtName;
			var ball = combinedList[i].ball;
			var placeFee = combinedList[i].placeFee;
			var reserveTime = combinedList[i].reserveTime;
			var reserveDate = combinedList[i].reserveDate;
			var ballText = '';
			if (ball === 0) {
				ballText = "籃球";
			} else if (ball === 1) {
				ballText = "排球";
			} else if (ball === 2) {
				ballText = "羽球";
			}
			// 这里可以访问generalUser数据，例如generalUser.gUserID、generalUser.nicknameID等
			var gUserID = generalUser.gUserID;
			var nicknameID = generalUser.nicknameID;
			var gProfilePic = generalUser.gProfilePic;
			if (gProfilePic) {
				var imageDataArray2 = new Uint8Array(gProfilePic);
				// 将二进制图像数据存储在Blob对象中
				var blob2 = new Blob([imageDataArray2], { type: 'image/jpeg' });
				// 创建一个Blob URL并将其设置为<img>标签的src属性
				var url2 = URL.createObjectURL(blob2);
			}
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
			var postID = post.postID;
			var likeCnt = post.likeCnt ? post.likeCnt : '';
			var commentCnt = post.commentCnt ? post.commentCnt : '';
			if (postType === 0) {
				$("#post-list").append(`
                		   <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
                		   <input type="hidden" class="saved-post-type" value="" />
                           <div class="row g-0">
                               <div class="col-md-8">
                               <input type="hidden" id="${gUserID}" >
                                   <div class="card-body">
                                       <h1 class="modal-title fs-5">
                                           <img src=${url2}  alt="大頭貼">
                                           <div>
                                               <a class="post_user">${nicknameID}</a>
                                               <div class="post_time">${post.postTime}</div>
                                           </div>
                                       </h1>
                                       <button type="button" class="edit_discuss" data-bs-toggle="modal" data-bs-target="#exampleModal_edit" id="editButton" data-post-id="${postID}">
                                       <i class="fa-regular fa-pen-to-square"></i>
                                           <span class="tooltip-text">編輯</span>
                                       </button>
                                       <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                                           <i class="fa-regular fa-trash-can"></i>
                                           <span class="tooltip-text">刪除</span>
                                       </button>
                                        <button type="button" class="report" data-bs-toggle="modal" data-bs-target="#exampleModal10" id="reportButton" data-post-id="${postID}">
                                <i class="fa-solid fa-triangle-exclamation"></i>
                                <span class="tooltip-text">檢舉</span>    
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
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> </button>
<span class="likecnt"> ${likeCnt > 0 ? likeCnt : ''}</span>
                            </div>
                                      <div class="col-2" id="commentcol" data-post-id="${postID}">
                    <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal" data-bs-target="#exampleModal5"></button>
                     <span class="commentcnt"> ${commentCnt > 0 ? commentCnt : ''}</span>
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
	                  <input type="hidden" id="${gUserID}" >
	                      <div class="card-body">
	                          <h1 class="modal-title fs-5" id="exampleModalLabel">
	                              <img src=${url2} alt="大頭貼">
	                              <div>
	                                  <a class="post_user">${nicknameID}</a>
	                                  <div class="post_time">${post.postTime}</div>
	                              </div>
	                          </h1>
	                          <button type="button" class="edit_group" data-bs-toggle="modal" data-bs-target="#exampleModal_edit2" id="editButton" data-post-id="${postID}">
                                          <i class="fa-regular fa-pen-to-square"></i>
                                              <span class="tooltip-text">編輯</span>
                                          </button>
                          <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                              <i class="fa-regular fa-trash-can"></i>
                              <span class="tooltip-text">刪除</span>
                          </button>
 <button type="button" class="report" data-bs-toggle="modal" data-bs-target="#exampleModal10" id="reportButton" data-post-id="${postID}">
                                <i class="fa-solid fa-triangle-exclamation"></i>
                                <span class="tooltip-text">檢舉</span>    
                            </button>
	                          <h5 class="card-title">${post.postTitle}</h5>
	                          <div class="container text-left">
	                              <div class="row">
	                                  <div class="col-2 col-sm-2">日期:</div>
	                                  <div class="col-2 col-sm-4">${reserveDate}</div>
	                                  <div class="w-100 d-none d-md-block"></div>

	                                  <div class="col-2 col-sm-2">時間:</div>
	                                  <div class="col-2 col-sm-4">${reserveTime}</div>
	                                  <div class="w-100 d-none d-md-block"></div>

	                                  <div class="col-2 col-sm-2">地點:</div>
	                                  <div class="col-2 col-sm-5">${courtName}</div>
	                                  <div class="w-100 d-none d-md-block"></div>

	                                  <div class="col-2 col-sm-2">球類:</div>
	                                  <div class="col-2 col-sm-4">${ballText}</div>
	                                  <div class="w-100 d-none d-md-block"></div>

	                                  <div class="col-2 col-sm-2">費用:</div>
	                                  <div class="col-2 col-sm-4">${placeFee}</div>
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
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> </button>
<span class="likecnt"> ${likeCnt > 0 ? likeCnt : ''}</span>
                            </div>
	                         <div class="col-2" id="commentcol" data-post-id="${postID}">
                    <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal" data-bs-target="#exampleModal5"></button>
                     <span class="commentcnt"> ${commentCnt > 0 ? commentCnt : ''}</span>
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
			if (currentUserId == gUserID) {
				$('#reportButton[data-post-id="' + postID + '"]').hide();
			} else {
				//			console.log('Hiding buttons');
				$('#editButton[data-post-id="' + postID + '"]').hide();
				$('#deleteButton[data-post-id="' + postID + '"]').hide();
			}
		}
	}
});