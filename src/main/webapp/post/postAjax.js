
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
		var selectedImage = $('#p_file').prop('files')[0];
		var imageElement = selectedImage ? `<img src="${URL.createObjectURL(selectedImage)}" class="img-fluid rounded-start" alt="..." id="articlepic" />` :
			postPic ? `<img src="${postPic}" class="img-fluid rounded-start" alt="..." id="articlepic" />` : '';
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
            ${imageElement}
        </div>
            <div class="container text-center">
                <div class="row align-items-start" id="card-footer">
                    <div class="col-2" id="likecol" data-post-id="${postID}">
                    <button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> ${likeCnt > 0 ? likeCnt : ''}</button>
                    </div>
                    <div class="col-2" id="commentcol" data-post-id="${postID}">
                    <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal" data-bs-target="#exampleModal5"> ${commentCnt > 0 ? commentCnt : ''}</button>
                    </div>
                </div>
            </div>
        </div>
    </div>`;

		$('#post-list').prepend(newPostElement);
	}

	function publishGroupPost(postID, postTitle, postContent, postType, postTime, postPic, likeCnt, commentCnt) {
		postContent = postContent.replace(/\n/g, '<br>');
		var selectedImage = $('#p_file').prop('files')[0];
		var imageElement = selectedImage ? `<img src="${URL.createObjectURL(selectedImage)}" class="img-fluid rounded-start" alt="..." id="articlepic" />` :
			postPic ? `<img src="${postPic}" class="img-fluid rounded-start" alt="..." id="articlepic" />` : '';
		// 創建新的揪團文章元素
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
                  <button type="button" class="edit_group" data-bs-toggle="modal" data-bs-target="#exampleModal_edit2" id="editButton" data-post-id="${postID}">
                              <i class="fa-regular fa-pen-to-square"></i>
                              <span class="tooltip-text">編輯</span>
                          </button>
                          <button type="button" class="delete" id="deleteButton" data-post-id="${postID}">
                              <i class="fa-regular fa-trash-can"></i>
                              <span class="tooltip-text">刪除</span>
                          </button>

                    <!--        <button type="button" class="report" data-bs-toggle="modal" data-bs-target="#exampleModal2" id="reportButton" data-post-id="${postID}">
                                <i class="fa-solid fa-triangle-exclamation"></i>
                                <span class="tooltip-text">檢舉</span>
                            </button>-->
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
                    ${imageElement}
                </div>
                    <div class="container text-center">
                        <div class="row align-items-start" id="card-footer">
                            <div class="col-2" id="likecol" data-post-id="${postID}">
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal6"> ${likeCnt > 0 ? likeCnt : ''}</button>                            </div>
                            <div class="col-2" id="commentcol" data-post-id="${postID}">
                                <button type="button" class="fa-regular fa-comment" data-bs-toggle="modal"
                                    data-bs-target="#exampleModal6" >  ${commentCnt > 0 ? commentCnt : ''}
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
		var selectedFiles = $("#p_file")[0].files;

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
		formData.append("postPic", selectedFiles[0]);

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
				fetchAndDisplayLatestData(response.postID, newPostTitle, newPostContent, response.postTime, selectedFiles);
				$("#exampleModal").modal("hide");
				console.log("發布成功:", response);
			},
			error: function(xhr, status, error) {
				console.error("發生錯誤:", status, error);
			}
		});
	});

	function fetchAndDisplayLatestData(postID, newPostTitle, newPostContent, postTime, selectedFiles) {
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
		                  ${selectedFiles && selectedFiles.length > 0 ? `<img src="${URL.createObjectURL(selectedFiles[0])}" alt="Selected Image" >` : ''}
		              </div>
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
		var selectedFiles = $("#p_file")[0].files;

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
		formData.append("postPic", selectedFiles[0]);

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
				fetchAndDisplayLatestData2(response.postID, newPostTitle, newPostContent, response.postTime, selectedFiles);
				$("#exampleModal").modal("hide");
				console.log("發布成功:", response);
			},
			error: function(xhr, status, error) {
				console.error("發生錯誤:", status, error);
			}
		});
	});

	function fetchAndDisplayLatestData2(postID, newPostTitle, newPostContent, postTime, selectedFiles) {
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
	                  ${selectedFiles && selectedFiles.length > 0 ? `<img src="${URL.createObjectURL(selectedFiles[0])}" alt="Selected Image" >` : ''}
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
		console.log("click");
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
				var postPic = postData.postPic;
				$("#preview_edit").html(`<img src="${postPic}" alt="預覽圖">`);

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
				var postPic = postData.postPic;
				$("#preview2_edit").html(`<img src="${postPic}" alt="預覽圖">`);

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
				$("#exampleModal_edit").modal("hide");
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
				// 	        	console.log("aa")
				 var likeCol = $(`
                <div class="col-2 likecol" id="likecol" data-post-id="${postData.postID}">
                    <button type="button" class="fa-regular fa-thumbs-up likebutton"></button>
                    ${postData.likeCnt>0?postData.likeCnt:''}
                </div>
            `);
				var formattedPostContent = postData.postContent.replace(/<br>/g, '\n');
				$(".card-title.article0").text(postData.postTitle);
				$(".card-text.article1").text(formattedPostContent);
				$(".posttime").text(postData.postTime);
			    $(".do").find(".likecol").replaceWith(likeCol);
				$(".commentcol").html(`<i class="fa-regular fa-comment"></i> ${postData.commentCnt>0?postData.commentCnt:''}`);
				$(".modal-image").attr("src", postData.postPic);
				//             console.log(postData.postTitle);
				//             console.log(postData.postContent);
				// 	            var postPic = postData.postPic;
				// 	            $("#preview_edit").html(`<img src="${postPic}" alt="預覽圖">`);

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
				console.log(postData.postID)
				console.log(postData.likeCnt)
				 var likeCol = $(`
                <div class="col-2 likecol" id="likecol" data-post-id="${postData.postID}">
                    <button type="button" class="fa-regular fa-thumbs-up likebutton"></button>
                    ${postData.likeCnt}
                </div>
            `);
				var formattedPostContent = postData.postContent.replace(/<br>/g, '\n');
				$(".card-title.article0").text(postData.postTitle);
				$(".card-text.article1").text(formattedPostContent);
				$(".posttime").text(postData.postTime);
			    $(".do").find(".likecol").replaceWith(likeCol);
				$(".commentcol").html(`<i class="fa-regular fa-comment"></i> ${postData.commentCnt}`);
				$(".modal-image").attr("src", postData.postPic);
				//             console.log(postData.postTitle);
				//             console.log(postData.postContent);
				// 	            var postPic = postData.postPic;
				// 	            $("#preview_edit").html(`<img src="${postPic}" alt="預覽圖">`);

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
				data: {
					"action": "get_By_gUserID",
					"gUserID": 11000001  // 根據實際情況傳遞相應的用戶ID
				},
				success: function(data) {
					$("#post-list").empty();
					// 將伺服器返回的結果顯示在搜索結果區域
					console.log(data);
					var posts = data;

					for (var i = 0; i < posts.length; i++) {

						var imageElement = posts[i].imageElement ? posts[i].imageElement : '';
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
                                   ${imageElement}
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
    	                  ${imageElement}
    	              </div>
    	                  <div class="container text-center">
    	                      <div class="row align-items-start" id="card-footer">
    	                          <div class="col-2" id="likecol">
<button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal6"> ${post[i].likeCnt > 0 ?[post[i]].likeCnt : ''}</button>    	                          </div>
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
						var imageElement = posts[i].imageElement ? posts[i].imageElement : '';
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
                                    ${imageElement}
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
              	                  ${imageElement}
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

						var imageElement = posts[i].imageElement ? posts[i].imageElement : '';
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
                                  ${imageElement}
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
   	                  ${imageElement}
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
			var imageElement = post.imageElement ? post.imageElement : '';
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
                               ${imageElement}
                           </div>
                               <div class="container text-center">
                                   <div class="row align-items-start" id="card-footer">
                                       <div class="col-2" id="likecol" data-post-id="${postID}">
                                            <button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal5"> ${posts[i].likeCnt > 0 ? posts[i].likeCnt : ''}</button>
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
	                  ${imageElement}
	              </div>
	                  <div class="container text-center">
	                      <div class="row align-items-start" id="card-footer">
	                          <div class="col-2" id="likecol" data-post-id="${postID}">
                                            <button type="button" class="fa-regular fa-thumbs-up likebutton" data-bs-toggle="modal" data-bs-target="#exampleModal6"> ${posts[i].likeCnt > 0 ? posts[i].likeCnt : ''}</button>
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