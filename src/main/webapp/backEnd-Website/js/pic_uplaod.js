// 取得上傳的檔案
const file = document.getElementById('file-input').files[0]; 

// 建立FileReader物件
const reader = new FileReader();

// 定義onload事件,上傳完成後顯示圖片  
reader.onload = function(e) {
  document.getElementById('imagePreview').src = e.target.result; 
};

// 讀取圖片檔案
reader.readAsDataURL(file);

// // 取得上傳的圖片文件对象
// const file = document.getElementById('file-input').files[0];

// // 建立FormData對象
// const formData = new FormData();
// formData.append('image', file); 

// // ajax請求上傳圖片
// $.ajax({
//   url: '/uploadImage',
//   method: 'POST',
//   data: formData,
//   processData: false, 
//   contentType: false,
//   success: function(response) {
//     // 上傳成功后設置圖片src
//     $('#imagePreview').attr('src', response.imageUrl);
//   }
// });

// Node.js服務器示例
app.post('/uploadImage', (req, res) => {

    // 存圖片到服务器
    const imageUrl = '/uploads/image.jpg'; 
    
    // 返回圖片URL
    res.json({imageUrl}); 
  })