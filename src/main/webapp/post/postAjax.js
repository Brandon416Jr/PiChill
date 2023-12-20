
//==============所有文章=============//
$(document).ready(function() {
	$.ajax({
		type: "GET",
		url: "post.do",
		dataType: "json",
		contentType: "application/json; charset=utf-8",
		success: function(data) {
			data.forEach(function(post) {
				if (post.postType === 0) {
					publishPost(post.postID, post.postTitle, post.postContent, post.postType, post.postTime, post.postPic, post.likeCnt, post.commentCnt);
				} else if (post.postType === 1) {
					publishGroupPost(post.postID, post.postTitle, post.postContent, post.postType, post.postTime, post.postPic, post.likeCnt, post.commentCnt);
				} else if (post.postType === 2) {
					publishPromotePost(post.postID, post.postTitle, post.postType, post.postTime);
				}
			});
		},
		error: function(xhr, status, error) {
			console.error("Error fetching posts:", status, error);
		}
	});

	function publishPost(postID, postTitle, postContent, postType, postTime, postPic, likeCnt, commentCnt) {
		postContent = postContent.replace(/\n/g, '<br>');
		if (postPic) {
			var imageDataArray = new Uint8Array(postPic);
			// 将二进制图像数据存储在Blob对象中
			var blob = new Blob([imageDataArray], { type: 'image/jpeg' });
			// 创建一个Blob URL并将其设置为<img>标签的src属性
			var url = URL.createObjectURL(blob);
		} else {
			url = '';
		}
		var newPostElement = `
    <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
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
                    <button type="button" class="edit_discuss" data-bs-toggle="modal" data-bs-target="#exampleModal_edit" id="editButton" data-post-id="${postID}">
                    <i class="fa-regular fa-pen-to-square"></i>
                        <span class="tooltip-text">編輯</span>
                    </button>
                    <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                        <i class="fa-regular fa-trash-can"></i>
                        <span class="tooltip-text">刪除</span>
                    </button>
                    <h5 class="card-title">${postTitle}</h5>
                    <p class="card-text">${postContent}</p>
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
    </div>`;

		$('#post-list').prepend(newPostElement);
	}

	function publishGroupPost(postID, postTitle, postContent, postType, postTime, postPic, likeCnt, commentCnt) {
		postContent = postContent.replace(/\n/g, '<br>');
		if (postPic) {
			var imageDataArray = new Uint8Array(postPic);
			// 将二进制图像数据存储在Blob对象中
			var blob = new Blob([imageDataArray], { type: 'image/jpeg' });
			// 创建一个Blob URL并将其设置为<img>标签的src属性
			var url = URL.createObjectURL(blob);
		} else {
			// 否则，显示空值
			url = '';
		}
		var newGroupPostElement = `
            	 <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
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
    <!--              <button type="button" class="edit_group" data-bs-toggle="modal" data-bs-target="#exampleModal_edit2" id="editButton" data-post-id="${postID}">
                              <i class="fa-regular fa-pen-to-square"></i>
                              <span class="tooltip-text">編輯</span>
                          </button>
                          <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                              <i class="fa-regular fa-trash-can"></i>
                              <span class="tooltip-text">刪除</span>
                          </button>-->

                            <button type="button" class="report" data-bs-toggle="modal" data-bs-target="#exampleModal10" id="reportButton" data-post-id="${postID}">
                                <i class="fa-solid fa-triangle-exclamation"></i>
                                <span class="tooltip-text">檢舉</span>
                            </button>
                            <h5 class="card-title">${postTitle}</h5>
                            <div class="container text-left">
                                <div class="row">
                                    <div class="col-2 col-sm-2">日期:</div>
                                    <div class="col-2 col-sm-4"></div>
                                    <div class="w-100 d-none d-md-block"></div>

                                    <div class="col-2 col-sm-2">時間:</div>
                                    <div class="col-2 col-sm-4"></div>
                                    <div class="w-100 d-none d-md-block"></div>

                                    <div class="col-2 col-sm-2">地點:</div>
                                    <div class="col-2 col-sm-4"></div>
                                    <div class="w-100 d-none d-md-block"></div>

                                    <div class="col-2 col-sm-2">球類:</div>
                                    <div class="col-2 col-sm-4"></div>
                                    <div class="w-100 d-none d-md-block"></div>

                                    <div class="col-2 col-sm-2">費用:</div>
                                    <div class="col-2 col-sm-4"></div>
                                </div>
                            </div>
                            <p class="card-text2">${postContent}</p>
                        </div>
                    </div>
                    <div class="col-md-4" id="piccontainer">
                    <img src="${url}">
                </div>
                    <div class="container text-center">
                        <div class="row align-items-start" id="card-footer">
                            <div class="col-2" id="likecol" data-post-id="${postID}">
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal6"> </button>
<span class="likecnt"> ${likeCnt > 0 ? likeCnt : ''}</span>
                            </div>
                            <div class="col-2" id="commentcol" data-post-id="${postID}">
                                <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal"
                                    data-bs-target="#exampleModal6" ></button>
                                     <span class="commentcnt"> ${commentCnt > 0 ? commentCnt : ''}</span>
                                </div>
                                                                   
                            <div class="col-2" id="pluscol">
                                <button type="button" class="fa-regular fa-square-plus"> +1
                            </div>
                        </div>
                    </div>
                </div>
            </div>`;

		$('#post-list').prepend(newGroupPostElement);
	}
	function publishPromotePost(postID, postTitle, postType, postTime) {
		var newPromotePostElement = `
				<div class="card mb-3 article2" id="article${postID}" style="width: 22rem;">
				<div class="row g-0">
					<div class="col-md-8">
						<div class="card-body">
							<h1 class="modal-title fs-5" id="exampleModalLabel">
								<img src="../image/Capybara.jpg" alt="大頭貼">
								<div>
									<a class="post_owner">水豚君</a>
									<div class="post_timer">${postTime}</div>
								</div>
							</h1>
							  <button type="button" class="edit_promote" data-bs-toggle="modal" data-bs-target="#exampleModalo_edit" id="editButton" data-post-id="${postID}">
                              <i class="fa-regular fa-pen-to-square"></i>
                              <span class="tooltip-text">編輯</span>
                          </button>
                          <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                              <i class="fa-regular fa-trash-can"></i>
                              <span class="tooltip-text">刪除</span>
                          </button>
							<h5 class="card-title">${postTitle}</h5>
	                          <p class="card-text">${postContent}</p>
							</p>
						</div>
					</div>
				</div>
			</div>`
		$('#promote-list').prepend(newPromotePostElement);

	}
	//========頁數顯示========
	// 在document上使用事件委派
	$(document).on('click', '.page-link', function() {
		// 獲取 data-page 屬性的值
		var page = $(this).data('page');
		loadPage(page);
	});

	function loadPage(page) {
		$.ajax({
			url: "post.do",
			type: "GET",
			data: { "page": page },
			dataType: "json",
			success: function(data) {
				$('#post-list').empty();
				var currentPage = data.currentPage;
				var postPageQty = data.postPageQty;
				data.sort(function(a, b) {
					// 按 postID 降序排序
					return b.postID - a.postID;
				});
				listAll(data);
				updatePagination(page, data.postPageQty);
			},
			error: function(xhr, status, error) {
				console.error("AJAX request failed:", status, error);
			}
		});
	}

	function listAll(data) {
		data.forEach(function(post) {
			if (post.postType === 0) {
				publishPost(post.postID, post.postTitle, post.postContent, post.postType, post.postTime, post.likeCnt);
			} else if (post.postType === 1) {
				publishGroupPost(post.postID, post.postTitle, post.postContent, post.postType, post.postTime, post.likeCnt);
			} else if (post.postType === 2) {
				publishPromotePost(post.postID, post.postTitle, post.postType, post.postTime);
			}
		});
	}

	function updatePagination(currentPage, postPageQty) {
		var pageElement = $("#page");

		pageElement.empty();

		// Previous Page Button
		pageElement.append('<li class="page-item"><a class="page-link" href="#" data-page="' + (currentPage - 1) + '"> <span aria-hidden="true">&laquo;</span></a></li>');

		// Page Buttons
		for (let i = 1; i <= postPageQty; i++) {
			pageElement.append('<li class="page-item"><a class="page-link" href="#" data-page="' + i + '">' + i + '</a></li>');
		}

		// Next Page Button
		pageElement.append('<li class="page-item"><a class="page-link" href="#" data-page="' + (currentPage + 1) + '" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>');

		// Unbind Previous Click Event
		pageElement.find("a.page-link").off('click');

		// Rebind Click Event
		pageElement.find("a.page-link").on('click', function() {
			var page = $(this).data('page');
			loadPage(page);
		});
	}

	//=============新增文章(討論)===============//
	$("#pb-discuss").on("click", function() {
		var newPostTitle = $("#floatingTextarea").val();
		var newPostContent = $("#floatingTextarea2").val();
		var discussType = $(".discussType").val();
		var newPostPic = $("#p_file")[0].files[0];

		if (newPostTitle.trim() === "") {
			alert("標題不得為空");
			return; // 如果標題為空，停止表單提交
		} else if (newPostContent.trim() === "") {
			alert("內文不得為空");
			return; // 如果內文為空，停止表單提交
		}
		newPostContent = newPostContent.replace(/\n/g, '<br>');
		let formData = new FormData();
		formData.append("action", "insert");
		formData.append("postTitle", newPostTitle);
		formData.append("postContent", newPostContent);
		formData.append("discussType", discussType);
		if (newPostPic) {
			// 用户选择了图像文件，将其添加到 FormData 中
			formData.append("postPic", newPostPic);
		}
		$.ajax({
			type: "POST",
			url: "post.do",
			data: formData,
			dataType: "json",
			processData: false,
			contentType: false,
			success: function(response) {
				console.log("伺服器回應:", response);
				// 	            	var newPostID = response.postID;
				fetchAndDisplayLatestData(response.postID, newPostTitle, newPostContent, response.postTime, newPostPic);
				$("#exampleModal").modal("hide");
				console.log("發布成功:", response);
			},
			error: function(xhr, status, error) {
				console.error("發生錯誤:", status, error);
			}
		});
	});

	function fetchAndDisplayLatestData(postID, newPostTitle, newPostContent, postTime, newPostPic) {
		// 發送請求以獲取最新資料
		$.ajax({
			type: "GET",
			url: "post.do",  // 替換成實際的後端處理檔案或API端點
			success: function(data) {
				var likeCnt = "";
				var commentCnt = "";
				// 		     	  var displayName = data.isAnonymous ? "匿名用戶" : "貓貓";
				// 		              var avatarPath = data.isAnonymous ? getAnonymousAvatarPath() : getMemberAvatarPath(data.memberID);
				var newPost =
					`<div class="card mb-3 article"  id="article${postID}" style="max-width: 700px;">
		              <div class="row g-0">
		                  <div class="col-md-8">
		                      <div class="card-body">
		                          <h1 class="modal-title fs-5">
		                              <img src="../image/cat.jpg" alt="大頭貼">
		                              <div>
		                                  <a class="post_user">貓貓</a>
		                                  <div class="post_time">${postTime}</div>
		                              </div>
		                        <button type="button" class="edit_discuss" data-bs-toggle="modal" data-bs-target="#exampleModal_edit" id="editButton" data-post-id="${postID}">
                        <i class="fa-regular fa-pen-to-square"></i>
                            <span class="tooltip-text">編輯</span>
                        </button>
                        <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                            <i class="fa-regular fa-trash-can"></i>
                            <span class="tooltip-text">刪除</span>
                        </button>
		                          <h5 class="card-title">${newPostTitle}</h5>
		                          <p class="card-text">${newPostContent}</p>
		                          
		                      </div>
		                  </div>
		                  <div class="col-md-4" id="piccontainer">
  ${newPostPic ? `<img src="${URL.createObjectURL(newPostPic)}" alt="Selected Image">` : ''}		              </div>
		                  <div class="container text-center">
		                      <div class="row align-items-start" id="card-footer">
		                          <div class="col-2" id="likecol" data-post-id="${postID}">
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> ${likeCnt > 0 ? likeCnt : ''}</button>		                          </div>
		                          <div class="col-2" id="commentcol" data-post-id="${postID}">
	                                <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal"
	                                    data-bs-target="#exampleModal5" > ${commentCnt}
	                                </div>
		                      </div>
		                  </div>
		              </div>
		          </div>`;
				// 將新文章添加到文章列表
				$('#post-list').prepend(newPost);
				$('#floatingTextarea').val('');
				$('#floatingTextarea2').val('');
				$('#p_file').val('');
				document.getElementById('preview').innerHTML = '';
			},
			error: function(error) {
				console.error(error);
				alert("發生錯誤，無法獲取最新資料。");
			}
		});
	}
	// 初始化時獲取一次最新資料
	$(document).ready(function() {
		fetchAndDisplayLatestData();
	});
	//=============新增文章(揪團))===============//
	$("#pb-group").on("click", function() {
		var newPostTitle = $("#floatingTextarea3").val();
		var newPostContent = $("#floatingTextarea4").val();
		var groupType = $(".groupType").val();
		var newPostPic = $("#p_file2")[0].files[0];

		if (newPostTitle.trim() === "") {
			alert("標題不得為空");
			return; // 如果標題為空，停止表單提交
		} else if (newPostContent.trim() === "") {
			alert("內文不得為空");
			return; // 如果內文為空，停止表單提交
		}
		newPostContent = newPostContent.replace(/\n/g, '<br>');
		let formData = new FormData();
		formData.append("action", "insert_group");
		formData.append("postTitle", newPostTitle);
		formData.append("postContent", newPostContent);
		formData.append("groupType", groupType);
		if (newPostPic) {
			// 用户选择了图像文件，将其添加到 FormData 中
			formData.append("postPic", newPostPic);
		}
		$.ajax({
			type: "POST",
			url: "post.do",
			data: formData,
			dataType: "json",
			processData: false,
			contentType: false,
			success: function(response) {
				console.log("伺服器回應:", response);
				// 	            	var newPostID = response.postID;
				fetchAndDisplayLatestData2(response.postID, newPostTitle, newPostContent, response.postTime, newPostPic);
				$("#exampleModal").modal("hide");
				console.log("發布成功:", response);
			},
			error: function(xhr, status, error) {
				console.error("發生錯誤:", status, error);
			}
		});
	});

	function fetchAndDisplayLatestData2(postID, newPostTitle, newPostContent, postTime, newPostPic) {
		// 發送請求以獲取最新資料
		$.ajax({
			type: "GET",
			url: "post.do",  // 替換成實際的後端處理檔案或API端點
			success: function(data) {
				var likeCnt = "";
				var commentCnt = "";
				var newPost = `
	            	    <div class="card mb-3 article" id="article${postID}" style="max-width: 700px;">
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
	                          <button type="button" class="edit_group" data-bs-toggle="modal" data-bs-target="#exampleModal_edit2" id="editButton" data-post-id="${postID}">
                              <i class="fa-regular fa-pen-to-square"></i>
                              <span class="tooltip-text">編輯</span>
                          </button>
                          <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                              <i class="fa-regular fa-trash-can"></i>
                              <span class="tooltip-text">刪除</span>
                          </button>

	                          <h5 class="card-title">${newPostTitle}</h5>
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
	                          <p class="card-text2">${newPostContent}</p>
	                      </div>
	                  </div>
	                  <div class="col-md-4" id="piccontainer">
  ${newPostPic ? `<img src="${URL.createObjectURL(newPostPic)}" alt="Selected Image">` : ''}		              </div>
	              </div>
	                  <div class="container text-center">
	                      <div class="row align-items-start" id="card-footer">
	                          <div class="col-2" id="likecol">
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal6"> ${likeCnt > 0 ? likeCnt : ''}</button>	                          </div>
	                          <div class="col-2" id="commentcol" data-post-id="${postID}">
	                              <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal"
	                                  data-bs-target="#exampleModal6" > ${commentCnt}
	                              </div>
	                          <div class="col-2" id="pluscol">
	                              <button type="button" class="fa-regular fa-square-plus"> +1
	                          </div>
	                      </div>
	                  </div>
	              </div>
	          </div>`;
				$('#post-list').prepend(newPost);

				$('#floatingTextarea3').val('');
				$('#floatingTextarea4').val('');
				$('#p_file2').val('');
				document.getElementById('preview2').innerHTML = '';
				$('#exampleModal').modal('hide');
			},
			error: function(xhr, status, error) {
				console.error("發生錯誤:", status, error);
			}
		});
	}
	// 初始化時獲取一次最新資料
	$(document).ready(function() {
		fetchAndDisplayLatestData();
	});
	//===========新增文章(推撥)==========
	$("#pb-promote").on("click", function() {
		var newPostTitle = $("#floatingTextarea5").val();
		var newPostContent = $("#floatingTextarea6").val();
		console.log(newPostTitle);
		if (newPostTitle.trim() === "") {
			alert("標題不得為空");
			return; // 如果標題為空，停止表單提交
		} else if (newPostContent.trim() === "") {
			alert("內文不得為空");
			return; // 如果內文為空，停止表單提交
		}
		newPostContent = newPostContent.replace(/\n/g, '<br>');
		let formData = new FormData();
		formData.append("action", "insert_promote");
		formData.append("postTitle", newPostTitle);
		formData.append("postContent", newPostContent);

		$.ajax({
			type: "POST",
			url: "post.do",
			data: formData,
			dataType: "json",
			processData: false,
			contentType: false,
			success: function(response) {
				console.log("伺服器回應:", response);
				// 	            	var newPostID = response.postID;
				fetchAndDisplayLatestData3(response.postID, newPostTitle, newPostContent, response.postTime);
				$("#exampleModal").modal("hide");
				console.log("發布成功:", response);
			},
			error: function(xhr, status, error) {
				console.error("發生錯誤:", status, error);
			}
		});
	});

	function fetchAndDisplayLatestData3(postID, newPostTitle, newPostContent, postTime) {
		// 發送請求以獲取最新資料
		$.ajax({
			type: "GET",
			url: "post.do",  // 替換成實際的後端處理檔案或API端點
			success: function(data) {
				var newPost = `
				<div class="card mb-3 article2" id="article${postID}" style="width: 22rem;">
				<div class="row g-0">
					<div class="col-md-8">
						<div class="card-body">
							<h1 class="modal-title fs-5" id="exampleModalLabel">
								<img src="../image/Capybara.jpg" alt="大頭貼">
								<div>
									<a class="post_owner">水豚君</a>
									<div class="post_timer">${postTime}</div>
								</div>
							</h1>
							  <button type="button" class="edit_promote" data-bs-toggle="modal" data-bs-target="#exampleModalo_edit" id="editButton" data-post-id="${postID}">
                              <i class="fa-regular fa-pen-to-square"></i>
                              <span class="tooltip-text">編輯</span>
                          </button>
                          <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                              <i class="fa-regular fa-trash-can"></i>
                              <span class="tooltip-text">刪除</span>
                          </button>
							<h5 class="card-title">${newPostTitle}</h5>
	                          <p class="card-text">${newPostContent}</p>
							</p>
						</div>
					</div>
				</div>
			</div>`
				$('#promote-list').prepend(newPost);

				$('#floatingTextarea5').val('');
				$('#floatingTextarea6').val('');
				$('#exampleModal_o').modal('hide');
			},
			error: function(xhr, status, error) {
				console.error("發生錯誤:", status, error);
			}
		});
	}
	// 初始化時獲取一次最新資料
	$(document).ready(function() {
		fetchAndDisplayLatestData3();
	});
	// =============編輯文章===============//
	// ===找到原先的值(討論)===//
	$("#post-list").on("click", ".edit_discuss", function() {
		//		console.log("click");
		var postID = $(this).data("post-id");
		var saveButton = $(".save-button_discuss");

		$.ajax({
			action: "getOne_For_Update",
			type: "GET",
			url: "post.do",
			data: { "postID": postID },
			dataType: "json",
			success: function(postData) {
				//				console.log("aa")
				PostContent = postData.postContent.replace(/<br>/g, '\n');
				$("#floatingTextarea_edit").val(postData.postTitle);
				$("#floatingTextarea2_edit").val(PostContent);
				if (postData.postPic) {
					var postPic = postData.postPic;
					var imageDataArray = new Uint8Array(postPic);

					// 将二进制图像数据存储在Blob对象中
					var blob = new Blob([imageDataArray], { type: 'image/jpeg' });

					// 创建一个Blob URL并将其设置为<img>标签的src属性
					var url = URL.createObjectURL(blob);
					$("#preview_edit").html(`<img src="${url}" alt="預覽圖">`);
				} else {
					// 如果没有图像数据，将src属性设置为空字符串
					$("#preview_edit").html('<img src="" >');
				}

				saveButton.attr("data-post-id", postData.postID);
			},
			error: function(xhr, status, error) {
				console.error("Get Post Details Error:", status, error);
			}
		});
	});
	//===找到原先的值(揪團)===//
	$("#post-list").on("click", ".edit_group", function() {
		//		console.log("click");
		var postID = $(this).data("post-id");
		var saveButton = $(".save-button_group");

		$.ajax({
			action: "getOne_For_Update",
			type: "GET",
			url: "post.do",
			data: { "postID": postID },
			dataType: "json",
			success: function(postData) {
				//				console.log("aa")
				PostContent = postData.postContent.replace(/<br>/g, '\n');
				$("#floatingTextarea3_edit").val(postData.postTitle);
				$("#floatingTextarea4_edit").val(PostContent);
				if (postData.postPic) {
					var postPic = postData.postPic;
					var imageDataArray = new Uint8Array(postPic);

					// 将二进制图像数据存储在Blob对象中
					var blob = new Blob([imageDataArray], { type: 'image/jpeg' });

					// 创建一个Blob URL并将其设置为<img>标签的src属性
					var url = URL.createObjectURL(blob);
					$("#preview2_edit").html(`<img src="${url}" alt="預覽圖">`);
				} else {
					// 如果没有图像数据，将src属性设置为空字符串
					$("#preview2_edit").html('<img src="" >');
				}

				saveButton.attr("data-post-id", postData.postID);
			},
			error: function(xhr, status, error) {
				console.error("Get Post Details Error:", status, error);
			}
		});
	});
	// ===找到原先的值(推撥)===//
	$("#promote-list").on("click", ".edit_promote", function() {
		console.log("click");
		var postID = $(this).data("post-id");
		var saveButton = $(".save-button_promote");

		$.ajax({
			action: "getOne_For_Update",
			type: "GET",
			url: "post.do",
			data: { "postID": postID },
			dataType: "json",
			success: function(postData) {
				//				console.log("aa")
				PostContent = postData.postContent.replace(/<br>/g, '\n');
				$("#floatingTextarea5_edit").val(postData.postTitle);
				$("#floatingTextarea6_edit").val(PostContent);

				saveButton.attr("data-post-id", postData.postID);
			},
			error: function(xhr, status, error) {
				console.error("Get Post Details Error:", status, error);
			}
		});
	});
	//===編輯動作(討論)===//
	$(".save-button_discuss").on("click", function() {
		// 	console.log("bbb");
		var postID = $(this).attr("data-post-id");
		var newPostTitle = $("#floatingTextarea_edit").val();
		var newPostContent = $("#floatingTextarea2_edit").val();
		var newPostPic = $("#p_file_edit")[0].files[0];
		if (newPostTitle.trim() === "") {
			alert("標題不得為空");
			return; // 如果標題為空，停止表單提交
		} else if (newPostContent.trim() === "") {
			alert("內文不得為空");
			return; // 如果內文為空，停止表單提交
		}
		var formData = new FormData();
		formData.append("action", "update");
		formData.append("postID", postID);
		formData.append("postTitle", newPostTitle);
		formData.append("postContent", newPostContent);
		formData.append("postPic", newPostPic);
		$.ajax({
			type: "POST",
			url: "post.do",
			data: formData,
			dataType: "json",
			processData: false,  // 不處理數據
			contentType: false,  // 不設置內容類型
			success: function(response) {
				console.log("Update Success:", response);
				$("#article" + postID + " .card-title").text(newPostTitle);
				$("#article" + postID + " .card-text").text(newPostContent);
				if (newPostPic) {
					var newImageElement = $("<img>").attr("src", URL.createObjectURL(newPostPic))
						.addClass("img-fluid rounded-start")
						.attr("alt", "...")
						.attr("id", "articlepic");

					// 将新的图片添加到piccontainer
					$("#article" + postID + " #piccontainer").empty().append(newImageElement);
				}
				$("#exampleModal_edit").modal("hide");
			},
			error: function(xhr, status, error) {
				console.error("Update Error:", status, error);

			}
		});
	})
	//===編輯動作(揪團)===//
	$(".save-button_group").on("click", function() {
		// 	console.log("bbb");
		var postID = $(this).attr("data-post-id");
		var newPostTitle = $("#floatingTextarea3_edit").val();
		var newPostContent = $("#floatingTextarea4_edit").val();
		var newPostPic = $("#p_file2_edit")[0].files[0];
		if (newPostTitle.trim() === "") {
			alert("標題不得為空");
			return; // 如果標題為空，停止表單提交
		} else if (newPostContent.trim() === "") {
			alert("內文不得為空");
			return; // 如果內文為空，停止表單提交
		}
		var formData = new FormData();
		formData.append("action", "update");
		formData.append("postID", postID);
		formData.append("postTitle", newPostTitle);
		formData.append("postContent", newPostContent);
		formData.append("postPic", newPostPic);
		$.ajax({
			type: "POST",
			url: "post.do",
			data: formData,
			dataType: "json",
			processData: false,  // 不處理數據
			contentType: false,  // 不設置內容類型
			success: function(response) {
				console.log("Update Success:", response);
				$("#article" + postID + " .card-title").text(newPostTitle);
				$("#article" + postID + " .card-text").text(newPostContent);
				if (newPostPic) {
					var newImageElement = $("<img>").attr("src", URL.createObjectURL(newPostPic))
						.addClass("img-fluid rounded-start")
						.attr("alt", "...")
						.attr("id", "articlepic");

					// 将新的图片添加到piccontainer
					$("#article" + postID + " #piccontainer").empty().append(newImageElement);
				}
				$("#exampleModal_edit2").modal("hide");
			},
			error: function(xhr, status, error) {
				console.error("Update Error:", status, error);

			}
		});
	})
	//=========編輯推撥=========
	$(".save-button_promote").on("click", function() {
		// 	console.log("bbb");
		var postID = $(this).attr("data-post-id");
		var newPostTitle = $("#floatingTextarea5_edit").val();
		var newPostContent = $("#floatingTextarea6_edit").val();
		if (newPostTitle.trim() === "") {
			alert("標題不得為空");
			return; // 如果標題為空，停止表單提交
		} else if (newPostContent.trim() === "") {
			alert("內文不得為空");
			return; // 如果內文為空，停止表單提交
		}
		var formData = new FormData();
		formData.append("action", "update_promote");
		formData.append("postID", postID);
		formData.append("postTitle", newPostTitle);
		formData.append("postContent", newPostContent);
		$.ajax({
			type: "POST",
			url: "post.do",
			data: formData,
			dataType: "json",
			processData: false,  // 不處理數據
			contentType: false,  // 不設置內容類型
			success: function(response) {
				console.log("Update Success:", response);
				$("#article" + postID + " .card-title").text(newPostTitle);
				$("#article" + postID + " .card-text").text(newPostContent);

				$("#exampleModalo_edit").modal("hide");
			},
			error: function(xhr, status, error) {
				console.error("Update Error:", status, error);

			}
		});
	})
	//=============刪除文章===============//
	$("#post-list").on("click", ".delete", function() {
		// 	        console.log("aaa");
		var postID = $(this).attr("data-post-id");
		var confirmDelete = confirm("是否確定刪除文章?");
		if (!confirmDelete) {
			return;
		}
		$.ajax({
			type: "POST",
			url: "post.do",
			data: {
				"action": "delete",
				"postID": postID
			},
			dataType: "json",
			success: function(data) {
				$("#post-list [data-post-id='" + postID + "']").closest('.card').fadeOut(1000, function() {
					$(this).remove();
				});
				console.log("Delete Success:", data);
			},
			error: function(xhr, status, error) {
				console.error("Delete Error:", status, error);
			}
		});
	});
	//=====刪除推撥文章========
	$("#promote-list").on("click", ".delete", function() {
		// 	        console.log("aaa");
		var postID = $(this).attr("data-post-id");
		var confirmDelete = confirm("是否確定刪除文章?");
		if (!confirmDelete) {
			return;
		}
		$.ajax({
			type: "POST",
			url: "post.do",
			data: {
				"action": "delete",
				"postID": postID
			},
			dataType: "json",
			success: function(data) {
				$("#promote-list [data-post-id='" + postID + "']").closest('.card').fadeOut(1000, function() {
					$(this).remove();
				});
				console.log("Delete Success:", data);
			},
			error: function(xhr, status, error) {
				console.error("Delete Error:", status, error);
			}
		});
	});

});