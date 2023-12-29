
//========新增文章檢舉========
$(document).ready(function() {
	$('#send_report2').click(function() {
		var postID = $('#reportButton').attr("data-post-id");
		var selectedOption = $("#exampleModal10 input[type='radio']:checked");
		var reportType;
		switch (selectedOption.next('label').text().trim()) {
			case '違反版規':
				reportType = 0;
				break;
			case '內容不實':
				reportType = 1;
				break;
			case '惡意洗版':
				reportType = 2;
				break;
			case '仇恨言論':
				reportType = 3;
				break;
			case '商業宣傳內容':
				reportType = 4;
				break;
			case '其他':
				reportType = 5;
				break;
		}
		$.ajax({
			type: "POST",
			url: "http://localhost:8081/PiChill/report/report.do",
			data: {
				"action": "insert_post",
				"postID": postID,
				"reportType": reportType,
			},
			dataType: "json",
			success: function(postData) {
				$('#exampleModal10').modal('hide');
				$("#exampleModal10 input[type='radio']").prop('checked', false);
				alert("已收到您的檢舉，我們將進行審查!");

			},
			error: function(xhr, status, error) {
				console.error("Get report Error:", status, error);
			}
		});
	});
	//========新增討論文章留言檢舉=====
	$('#send_report').click(function() {
		var commentID = $('.btn_report').attr("data-comment-id");
		var selectedOption = $("#exampleModal2 input[type='radio']:checked");
		var reportType;
		//		console.log(commentID);
		switch (selectedOption.next('label').text().trim()) {
			case '違反版規':
				reportType = 0;
				break;
			case '內容不實':
				reportType = 1;
				break;
			case '惡意洗版':
				reportType = 2;
				break;
			case '仇恨言論':
				reportType = 3;
				break;
			case '商業宣傳內容':
				reportType = 4;
				break;
			case '其他':
				reportType = 5;
				break;
		}
		$.ajax({
			type: "POST",
			url: "http://localhost:8081/PiChill/report/report.do",
			data: {
				"action": "insert_comment",
				"commentID": commentID,
				"reportType": reportType,
			},
			dataType: "json",
			success: function(postData) {
				$('#exampleModal2').modal('hide');
				$("#exampleModal2 input[type='radio']").prop('checked', false);
				alert("已收到您的檢舉，我們將進行審查!");

			},
			error: function(xhr, status, error) {
				console.error("Get report Error:", status, error);
			}
		});
	});
	//========新增揪團文章留言檢舉=====
	$('#send_report3').click(function() {
		var commentID = $('.btn_report').attr("data-comment-id");
		var selectedOption = $("#exampleModal11 input[type='radio']:checked");
		var reportType;
		console.log(commentID);
		switch (selectedOption.next('label').text().trim()) {
			case '違反版規':
				reportType = 0;
				break;
			case '內容不實':
				reportType = 1;
				break;
			case '惡意洗版':
				reportType = 2;
				break;
			case '仇恨言論':
				reportType = 3;
				break;
			case '商業宣傳內容':
				reportType = 4;
				break;
			case '其他':
				reportType = 5;
				break;
		}
		$.ajax({
			type: "POST",
			url: "http://localhost:8081/PiChill/report/report.do",
			data: {
				"action": "insert_comment",
				"commentID": commentID,
				"reportType": reportType,
			},
			dataType: "json",
			success: function(postData) {
				$('#exampleModal11').modal('hide');
				$("#exampleModal11 input[type='radio']").prop('checked', false);
				alert("已收到您的檢舉，我們將進行審查!");

			},
			error: function(xhr, status, error) {
				console.error("Get report Error:", status, error);
			}
		});
	});
	//======新增/取消按讚======
	$("#exampleModal5").on("click", "#likecol", function() {
		var postID = $(this).attr("data-post-id");
		var gUserID = $("#userID").val();
		//		console.log(postID);
		var $likeDiv = $(this);
		//console.log($(this).html())
		//console.log($likeDiv)
		$likeDiv.animate({
			marginTop: '-10px'
		}, {
			duration: 100,
			complete: function() {
				$likeDiv.animate({
					marginTop: '10px'
				}, {
					duration: 100,
					complete: function() {
						$.ajax({
							type: "POST",
							url: "http://localhost:8081/PiChill/forumlike/forumlike.do",
							data: {
								"action": "likepost",
								"postID": postID,
								"gUserID": gUserID,
							},
							dataType: "json",
							success: function(data) {
								console.log("成功按讚");
								if (data.status == 1) {
									$likeDiv.find(".likebutton").css('color', 'blue');
								} else if (data.status == 0) {
									$likeDiv.find(".likebutton").css('color', '');
								}
								var $likeCntSpan = $("#likecol[data-post-id='" + postID + "'] .fa-thumbs-up").siblings(".likecnt");
								$likeCntSpan.empty(); // 清空原本的评论数量
								// 更新按讚數量
								if (data.likeCnt === 0) {
									$likeCntSpan.text(''); // 如果新的点赞数量为0，显示为空字符串
								} else {
									$likeCntSpan.text(' ' + data.likeCnt);
								}
								//====更新likeCnt到post資料庫====
								$.ajax({
									type: "POST",
									url: "http://localhost:8081/PiChill/post/post.do",
									data: {
										"action": "update_likeCnt",
										"postID": postID,
										"likeCnt": data.likeCnt
									},
									dataType: "json",
									success: function(response) {
										console.log("點讚成功")
									},
									error: function(xhr, status, error) {
										console.error("Error:", status, error);
									}
								});
							},
							error: function(xhr, status, error) {
								console.error("Error:", status, error);
							}
						});
					}
				});
			}
		});
	});

	$("#exampleModal6").on("click", "#likecol", function() {
		var postID = $(this).attr("data-post-id");
		//		console.log(postID);
		var gUserID = $("#userID").val();
		var $likeDiv = $(this);
		//console.log($(this).html())
		//console.log($likeDiv)
		$likeDiv.animate({
			marginTop: '-10px'
		}, {
			duration: 100,
			complete: function() {
				$likeDiv.animate({
					marginTop: '10px'
				}, {
					duration: 100,
					complete: function() {
						$.ajax({
							type: "POST",
							url: "http://localhost:8081/PiChill/forumlike/forumlike.do",
							data: {
								"action": "likepost",
								"postID": postID,
								"gUserID": gUserID,
							},
							dataType: "json",
							success: function(data) {
								console.log("成功按讚");
								if (data.status == 1) {
									$likeDiv.find(".likebutton").css('color', 'blue');
								} else if (data.status == 0) {
									$likeDiv.find(".likebutton").css('color', '');
								}
								var $likeCntSpan = $("#likecol[data-post-id='" + postID + "'] .fa-thumbs-up").siblings(".likecnt");
								$likeCntSpan.empty(); // 清空原本的评论数量
								// 更新按讚數量
								if (data.likeCnt === 0) {
									$likeCntSpan.text(''); // 如果新的点赞数量为0，显示为空字符串
								} else {
									$likeCntSpan.text(' ' + data.likeCnt);
								}
								//====更新likeCnt到post資料庫====
								$.ajax({
									type: "POST",
									url: "http://localhost:8081/PiChill/post/post.do",
									data: {
										"action": "update_likeCnt",
										"postID": postID,
										"likeCnt": data.likeCnt
									},
									dataType: "json",
									success: function(response) {
										if (response.success) {
											console.log("點讚數量更新成功");
										} else {
											console.error("點讚數量更新失败: " + response.message);
										}
									},
									error: function(xhr, status, error) {
										console.error("Error:", status, error);
									}
								});

							},
							error: function(xhr, status, error) {
								console.error("Error:", status, error);
							}
						});
					}
				});
			}
		});
	});
	//========所有留言=========
	$("#post-list").on("click", "#commentcol", function() {
		$(".task_list").empty();
		var postID = $(this).data("post-id");
		var postType = $("input.postType").val();
		//		console.log(postType);
		$.ajax({
			url: "http://localhost:8081/PiChill/comment/comment.do",
			type: "GET",
			data: {
				action: "list_All",
				"postID": postID
			},
			dataType: "json",
			contentType: "application/json; charset=utf-8",
			success: function(data) {
				data.forEach(function(comment) {
					//					console.log(postType);
					publishcomment(comment.comment.commentID, comment.comment.commentContent, comment.comment.commentTime, comment.generalUser.gUserID, comment.generalUser.nicknameID, comment.generalUser.gProfilePic);
				});
			},
			error: function(xhr, status, error) {
				console.error("Error fetching comments:", status, error);
			}
		});
	});

	function publishcomment(commentID, commentContent, commentTime, gUserID, nicknameID, gProfilePic) {
		// 初始化 HTML 字串
		var currentUserId = $('#userID').val();
		if (gProfilePic) {
			var imageDataArray2 = new Uint8Array(gProfilePic);
			// 将二进制图像数据存储在Blob对象中
			var blob2 = new Blob([imageDataArray2], { type: 'image/jpeg' });
			// 创建一个Blob URL并将其设置为<img>标签的src属性
			var url2 = URL.createObjectURL(blob2);
		}
		var list_html = '<li>';
		list_html += '<div class="item_flex">';
		list_html += '<div class="left_block">';
		list_html += '<input type="hidden" id="gUserID" value="' + gUserID + '">';
		list_html += '<div class="comment_img"> <img src=" ' + url2 + '" alt="大頭貼"></div>';
		list_html += '<div>';
		list_html += '<a class="comment_user">' + nicknameID + '</a>';
		list_html += '<div class="comment_time">' + commentTime + '</div>'
		list_html += '</div>';
		list_html += '</div>';
		list_html += '<div class="middle_block">';
		list_html += '<p class="para">' + commentContent + '</p>';
		// 假設 'task_text' 是您想在輸入框中顯示的預設文字
		list_html += '<input type="text" class="task_name_update -none" placeholder="更新留言…" value="' + commentContent + '">';
		list_html += '</div>';
		list_html += '<div class="right_block">';
		list_html += '<div class="btn_flex">';
		list_html += '<button type="button" class="btn_update" data-comment-id=' + commentID + '>';
		list_html += '<i class="fa-regular fa-pen-to-square"></i>';
		list_html += '<span class="tooltip-text">編輯</span>';
		list_html += '</button>'
		list_html += '<button type="button" class="btn_delete" data-comment-id=' + commentID + '>';
		list_html += '<i class="fa-regular fa-trash-can"></i>'
		list_html += '<span class="tooltip-text">刪除</span>'
		list_html += '</button>'
		var postType = $("input.postType").val(); // 取得 postType 的值

		if (postType === "0") { // 如果 postType 為 "1"，顯示檢舉按鈕
			list_html += '<button type="button" class="btn_report" data-bs-toggle="modal" data-bs-target="#exampleModal2"  id="openSecondModal" data-comment-id=' + commentID + '>';
			list_html += '<i class="fa-solid fa-triangle-exclamation"></i>'
			list_html += '<span class="tooltip-text">檢舉</span>'
			list_html += '</button>'
		} else if (postType === "1") {
			list_html += '<button type="button" class="btn_report" data-bs-toggle="modal" data-bs-target="#exampleModal11"  id="openSecondModal" data-comment-id=' + commentID + '>';
			list_html += '<i class="fa-solid fa-triangle-exclamation"></i>'
			list_html += '<span class="tooltip-text">檢舉</span>'
			list_html += '</button>'
		}
		list_html += '</div>';
		list_html += '</div>';
		list_html += '</div>';
		list_html += '</li>';

		// 將生成的 HTML 插入到頁面的指定元素中
		$('.task_list').prepend(list_html);
		$("#exampleModal5").modal("hide");
		// 获取檢舉按钮元素
		if (currentUserId == gUserID) {
			$('.btn_report[data-comment-id="' + commentID + '"]').hide();
		} else {
			console.log("進來了")
			$('.btn_update[data-comment-id="' + commentID + '"]').hide();
			$('.btn_delete[data-comment-id="' + commentID + '"]').hide();
		}
	};
	//=======編輯留言==========
	$(".task_list_parent").on("click", "ul.task_list button.btn_update", function() {
		if ($(this).attr("data-edit") == undefined) { // 進入編輯狀態
			$(this).attr("data-edit", true);
			$(this).closest("li").find("p.para").toggleClass("-none");
			$(this).closest("li").find("input.task_name_update").toggleClass("-none");
			// 監聽按鍵事件
			$(this).closest("li").find("input.task_name_update").on("keyup", function(event) {
				if (event.key === "Enter") {
					console.log("Enter key pressed");
					saveUpdate($(this));
				}
			});
		} else {
			let update_task_name = ($(this).closest("li").find("input.task_name_update").val()).trim();
			if (update_task_name == "") {
				alert("請輸入待辦事項");
			} else {
				saveUpdate($(this));
			}
		}
	});


	//========新增留言===========
	function addComment() {
		let task_text = $("input.task_name").val().trim();
		let likecolElements = $(".likecol");
		var gUserID = $("#userID").val();
		// 取得第一個具有 "likecol" 類別的元素的 data-post-id 值
		let postID = likecolElements.eq(0).data('post-id');
		//        console.log(postID);
		if (task_text != "") {
			$.ajax({
				url: "http://localhost:8081/PiChill/comment/comment.do",
				type: 'POST',
				dataType: 'json',
				data: {
					"action": "insert",
					"postID": postID,
					"gUserID": gUserID,
					"commentContent": task_text
				},
				success: function(response) {
					let commentTime = response.addedComment.commentTime;
					let commentID = response.addedComment.commentID;
					let nicknameID = response.generalUser.nicknameID;
					let gProfilePic = response.generalUser.gProfilePic;
					if (gProfilePic) {
						var imageDataArray2 = new Uint8Array(gProfilePic);
						// 将二进制图像数据存储在Blob对象中
						var blob2 = new Blob([imageDataArray2], { type: 'image/jpeg' });
						// 创建一个Blob URL并将其设置为<img>标签的src属性
						var url2 = URL.createObjectURL(blob2);
					}
					let list_html = "";
					list_html += '<li>';
					list_html += '<div class="item_flex">';
					list_html += '<div class="left_block">';
					list_html += '<div class="comment_img"> <img src=" ' + url2 + '" alt="大頭貼"></div>';
					list_html += '<div>';
					list_html += '<a class="comment_user">' + nicknameID + '</a>';
					list_html += '<div class="comment_time">' + commentTime + '</div>'
					list_html += '</div>';
					list_html += '</div>';
					list_html += '<div class="middle_block">';
					list_html += '<p class="para">' + task_text + '</p>';
					list_html += '<input type="text" class="task_name_update -none" placeholder="更新留言…" value="' + task_text + '">';
					list_html += '</div>';
					list_html += '<div class="right_block">';
					list_html += '<div class="btn_flex">';
					list_html += '<button type="button" class="btn_update" data-comment-id=' + commentID + '>';
					list_html += ' <i class="fa-regular fa-pen-to-square"></i>';
					list_html += ' <span class="tooltip-text">編輯</span>';
					list_html += '</button>';
					list_html += '<button type="button" class="btn_delete" data-comment-id=' + commentID + '>';
					list_html += '    <i class="fa-regular fa-trash-can"></i>';
					list_html += '      <span class="tooltip-text">刪除</span>';
					list_html += '   </button>';
					list_html += '</div>';
					list_html += '</div>';
					list_html += '</div>';
					list_html += '</li>';
					$("ul.task_list").prepend(list_html);
					//					console.log(response.commentCnt)
					//					console.log(postID);
					var $commentCntSpan = $("#commentcol[data-post-id='" + postID + "'] .fa-comment").siblings(".commentcnt");
					$commentCntSpan.empty(); // 清空原本的评论数量
					$commentCntSpan.text(' ' + response.commentCnt);
					//=========留言數update到post=============
					$.ajax({
						type: "POST",
						url: "http://localhost:8081/PiChill/post/post.do",
						data: {
							"action": "update_commentCnt",
							"postID": postID,
							"commentCnt": response.commentCnt
						},
						dataType: "json",
						success: function(response2) {
							console.log("留言成功")
						},
						error: function(xhr, status, error) {
							console.error("Error:", status, error);
						}
					});
				},
				error: function(xhr, status, error) {
					console.error("留言新增失敗:", error);
				}
			});

			$("input.task_name").val("");
		}
	}
	// 綁定 Enter 鍵事件
	$("input.task_name").on("keyup", function(e) {
		if (e.which == 13) { // 按下 Enter 鍵
			addComment();
		}
	});

	// 綁定新增按鈕點擊事件
	$("button.task_add").on("click", function() {
		addComment();
	});
	//===揪團的新增留言====
	function addComment2() {
		let task_text = $("input.task_name2").val().trim();
		let likecolElements = $(".likecol");
		var gUserID = $("#userID").val();
		// 取得第一個具有 "likecol" 類別的元素的 data-post-id 值
		let postID = likecolElements.eq(0).data('post-id');
		//		console.log(postID);
		if (task_text != "") {
			$.ajax({
				url: "http://localhost:8081/PiChill/comment/comment.do",
				type: 'POST',
				dataType: 'json',
				data: {
					"action": "insert",
					"postID": postID,
					"gUserID": gUserID,
					"commentContent": task_text
				},
				success: function(response) {
					let commentTime = response.addedComment.commentTime;
					let commentID = response.addedComment.commentID;
					let nicknameID = response.generalUser.nicknameID;
					let gProfilePic = response.generalUser.gProfilePic;
					if (gProfilePic) {
						var imageDataArray2 = new Uint8Array(gProfilePic);
						// 将二进制图像数据存储在Blob对象中
						var blob2 = new Blob([imageDataArray2], { type: 'image/jpeg' });
						// 创建一个Blob URL并将其设置为<img>标签的src属性
						var url2 = URL.createObjectURL(blob2);
					}
					let list_html = "";
					list_html += '<li>';
					list_html += '<div class="item_flex">';
					list_html += '<div class="left_block">';
					list_html += '<div class="comment_img"> <img src=" ' + url2 + '" alt="大頭貼"></div>';
					list_html += '<div>';
					list_html += '<a class="comment_user">' + nicknameID + '</a>';
					list_html += '<div class="comment_time">' + commentTime + '</div>'
					list_html += '</div>';
					list_html += '</div>';
					list_html += '<div class="middle_block">';
					list_html += '<p class="para">' + task_text + '</p>';
					list_html += '<input type="text" class="task_name_update -none" placeholder="更新留言…" value="' + task_text + '">';
					list_html += '</div>';
					list_html += '<div class="right_block">';
					list_html += '<div class="btn_flex">';
					list_html += '<button type="button" class="btn_update" data-comment-id=' + commentID + '>';
					list_html += ' <i class="fa-regular fa-pen-to-square"></i>';
					list_html += ' <span class="tooltip-text">編輯</span>';
					list_html += '</button>';
					list_html += '<button type="button" class="btn_delete" data-comment-id=' + commentID + '>';
					list_html += '    <i class="fa-regular fa-trash-can"></i>';
					list_html += '      <span class="tooltip-text">刪除</span>';
					list_html += '   </button>';
					list_html += '</div>';
					list_html += '</div>';
					list_html += '</div>';
					list_html += '</li>';

					$("ul.task_list").prepend(list_html);

					var $commentCntSpan = $("#commentcol[data-post-id='" + postID + "'] .fa-comment").siblings(".commentcnt");
					$commentCntSpan.empty(); // 清空原本的评论数量
					$commentCntSpan.text(' ' + response.commentCnt);
					//=========留言數update到post=============
					$.ajax({
						type: "POST",
						url: "http://localhost:8081/PiChill/post/post.do",
						data: {
							"action": "update_commentCnt",
							"postID": postID,
							"commentCnt": response.commentCnt
						},
						dataType: "json",
						success: function(response2) {
							console.log("success")
						},
						error: function(xhr, status, error) {
							console.error("Error:", status, error);
						}
					});
				},
				error: function(xhr, status, error) {
					console.error("留言新增失敗:", error);
				}
			});

			$("input.task_name2").val("");
		}
	}
	// 綁定 Enter 鍵事件
	$("input.task_name2").on("keyup", function(e) {
		if (e.which == 13) { // 按下 Enter 鍵
			addComment2();
		}
	});

	// 綁定新增按鈕點擊事件
	$("button.task_add").on("click", function() {
		addComment2();
	});
	//==========刪除留言=========
	$(".task_list_parent").on("click", "ul.task_list button.btn_delete", function() {
		//		console.log("aa");
		let r = confirm("是否確定刪除留言？");
		if (r) {
			var commentID = $(this).attr("data-comment-id");
			var commentElement = $(this).closest("li");
			let likecolElements = $(".likecol");
			let postID = likecolElements.eq(0).data('post-id');
			console.log(commentID);
			console.log(postID);
			$.ajax({
				url: "http://localhost:8081/PiChill/comment/comment.do",
				type: 'POST',
				data: {
					"action": "delete",
					"commentID": commentID,
					"postID": postID
				},
				success: function(response) {
					// 刪除動畫
					commentElement.animate({
						"opacity": 0
					}, 1000, "swing", function() {
						commentElement.remove();
					});

					var $commentCntSpan = $("#commentcol[data-post-id='" + postID + "'] .fa-comment").siblings(".commentcnt");

					$commentCntSpan.empty(); // 清空原本的评论数量
					if (response.commentCnt === 0) {
						$commentCntSpan.text(''); // 如果新的点赞数量为0，显示为空字符串
					} else {
						$commentCntSpan.text(' ' + response.commentCnt); // 否则显示新的点赞数量
					}
					//=========留言數update到post=============
					$.ajax({
						type: "POST",
						url: "http://localhost:8081/PiChill/post/post.do",
						data: {
							"action": "update_commentCnt",
							"postID": postID,
							"commentCnt": response.commentCnt
						},
						dataType: "json",
						success: function(response2) {
							if (response2.success) {
								console.log("留言數更新成功");
							} else {
								console.error("留言數更新失败: " + response2.message);
							}
						},
						error: function(xhr, status, error) {
							console.error("Error:", status, error);
						}
					});
				},
				error: function(xhr, status, error) {
					console.error("留言刪除失敗:", error);
				}
			});
		}
	});
	//=======編輯留言==========
	function saveUpdate(button) {
		let update_task_name = button.closest("li").find("input.task_name_update").val().trim();
		let commentID = button.closest("li").find("button.btn_delete").attr("data-comment-id");

		$.ajax({
			url: "http://localhost:8081/PiChill/comment/comment.do",
			type: 'POST',
			data: {
				"action": "update",
				"commentID": commentID,
				"commentContent": update_task_name
			},
			success: function(response) {
				// 更新成功時的處理
				console.log("更新成功");
			},
			error: function(xhr, status, error) {
				console.error("更新失敗:", error);
			}
		});

		button.closest("li").find("p.para").html(update_task_name).toggleClass("-none");
		button.closest("li").find("input.task_name_update").val(update_task_name).toggleClass("-none");
		button.removeAttr("data-edit");

		// 移除按鍵事件監聽器
		button.closest("li").find("input.task_name_update").off("keyup");
	}
});