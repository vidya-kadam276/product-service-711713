package com.jbk.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jbk.exception.ResourceNotExistsException;
import com.jbk.exception.SomethingWentWrongException;
import com.jbk.model.ProductModel;
//import com.jbk.service.CategoryService;
//import com.jbk.service.SupplierService;

@Component
public class ObjectValidator {

	

	

	public Map<String, String> validateProduct(ProductModel productModel) {
		Map<String, String> validationMap = new HashMap<String, String>();

		String productName = productModel.getProductName();
		double productPrice = productModel.getProductPrice();
		int productQty = productModel.getProductQty();
		int deliveryCharges = productModel.getDeliveryCharges();
		long supplierId = productModel.getSupplierId();
		long categoryId = productModel.getCategoryId();

		if (productName == null || productName.trim().equals("")) {
			validationMap.put("Product Name", "Invalid Product Name");
		}

		if (productPrice <= 0) {
			validationMap.put("Product Price", "Product Price Must be Greater than 0");
		}

		if (productQty <= 0) {
			validationMap.put("Product Qty", "Product Qty Must be Greater than 0");
		}

		if (deliveryCharges < 0) {
			validationMap.put("Charges ", "Delivery Charges Should Not be Negative");
		}

		if (supplierId > 0) {
			try {
				//supplierService.getSupplierById(supplierId);

			} catch (ResourceNotExistsException e) {
				validationMap.put("Supplier", e.getMessage());
			} catch (SomethingWentWrongException e) {
				validationMap.put("Supplier", e.getMessage());
			}
		} else {
			validationMap.put("Supplier", "Invalid Supplier Id");
		}

		if (categoryId > 0) {
			try {
				//categoryService.getCategoryById(categoryId);

			} catch (ResourceNotExistsException e) {
				validationMap.put("Supplier", e.getMessage());
			} catch (SomethingWentWrongException e) {
				validationMap.put("Supplier", e.getMessage());
			}
		} else {
			validationMap.put("Supplier", "Invalid Supplier Id");
		}

		return validationMap;

	}

}
