package com.pichill.contactus.service;

import java.util.List;

import com.pichill.contactus.entity.ContactUs;
import com.pichill.contactus.model.ContactUsDAO;
import com.pichill.contactus.model.ContactUsDAOImpl;


public class ContactUsServiceImpl extends ContactUsService {
	
	private static final long PAGE_MAX_RESULT = 3;  
	//“max-results”參數可讓您提前指定您希望接收的結果數量。最大值為10,000。若要取得超過10,000行的結果，必須使用分頁功能多次呼叫API。
	private final ContactUsDAO cDao;
	
	public ContactUsServiceImpl() {
		cDao = new ContactUsDAOImpl();
		
	}
		@Override
		public int addContactUs(ContactUs contactUs) {
			Integer id = cDao.add(contactUs);
			contactUs = cDao.getContactUsByFormID(id);
//			return contactUs;
			return cDao.add(contactUs);//返回給controller
		}

		public ContactUs addContactUs(String formPurpose,String formContent,Integer formtype) {
			ContactUs form = new ContactUs();
			form.setformPurpose(formPurpose);
			form.setformContent(formContent);
			form.setformType(formtype);
			cDao.add(form);
		return form;
//			return dao.insert(contactUs);//返回給controller
		}
//		@Override
//		public ContactUs updateContactUs(ContactUs contactUs) {
//			if (dao.update(ContactUs) == 1) {
//				return ContactUs;
//			} else
//				return null;
//		}
		


//		@Override
//		public List<ContactUs> getContactUsByformPurpose(String formPurpose) {
//			return dao.getByPurpose(formPurpose);
//		}
//
//		@Override
//		public ContactUs updateContactUs(ContactUs contactUs) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		@Override
//		public ContactUs getByPostID(Integer formID) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		@Override
//		public List<ContactUs> getContactUsByformType(Integer formType) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		@Override
//		public List<ContactUs> getContactUsByformContent(String formContent) {
//			return dao.getByContent(formContent);
//		}
//
//		@Override
//		public List<ContactUs> getContactUsByformPic(byte[] formPic) {
//			return dao.getByformPic(formPic);
//		}
//		
//		@Override
//		public List<ContactUs> getAll() {
//			return dao.getAll();
//		}


//		@Override
//		public List<Post> getAllPosts(int currentPage) {
//			return dao.getAll(currentPage);
//		}
	//
//		@Override
//		public int getPageTotal() {
//			long total =dao.getTotal();
//			int pageQty = (int)(total%PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
//			return pageQty;
//		}
	//
//		@Override
//		public List<Post> getPostsByCompositeQuery(Map<String, String[]> map) {
//			Map<String, String> query = new HashMap<>();
//			// Map.Entry即代表一組key-value
//			Set<Map.Entry<String, String[]>> entry = map.entrySet();
//			
//			for (Map.Entry<String, String[]> row : entry) {
//				String key = row.getKey();
//				// 因為請求參數裡包含了action，做個去除動作
//				if ("action".equals(key)) {
//					continue;
//				}
//				// 若是value為空即代表沒有查詢條件，做個去除動作
//				String value = row.getValue()[0]; // getValue拿到一個String陣列, 接著[0]取得第一個元素檢查
//				if (value == null || value.isEmpty()) {
//					continue;
//				}
//				query.put(key, value);
//			}
//			
//			System.out.println(query);
//			
//			return dao.getByCompositeQuery(query);
//		}
	}
