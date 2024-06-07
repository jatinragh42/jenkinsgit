package com.rays.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.OrderDTO;
import com.rays.dto.ProductDTO;

@Repository
public class OrderDAOImpl extends BaseDAOImpl<OrderDTO> implements OrderDAOInt {

	@Override
	public Class<OrderDTO> getDTOClass() {
		return OrderDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(OrderDTO dto, CriteriaBuilder builder, Root<OrderDTO> qRoot) {
		// Create where conditions
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isZeroNumber(dto.getQuantity())) {

			whereCondition.add(builder.like(qRoot.get("quantity"), dto.getQuantity() + "%"));
		}

		if (!isZeroNumber(dto.getAmount())) {

			whereCondition.add(builder.equal(qRoot.get("amount"), dto.getAmount()));
		}

		if (isNotNull(dto.getDate())) {
			// Assuming "date" field is of type java.util.Date or java.sql.Date
			Date searchDate = dto.getDate();

			// Define start and end dates for the search day
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(searchDate);
			calendar.set(Calendar.HOUR_OF_DAY, 0); // Start of the day
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			Date startDate = calendar.getTime();

			calendar.set(Calendar.HOUR_OF_DAY, 23); // End of the day
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			Date endDate = calendar.getTime();

			// Create predicate for date range
			Predicate datePredicate = builder.between(qRoot.get("date"), startDate, endDate);
			whereCondition.add(datePredicate);
		}

		if (!isZeroNumber(dto.getProductId())) {

			whereCondition.add(builder.equal(qRoot.get("productId"), dto.getProductId()));
		}

		if (!isEmptyString(dto.getProductName())) {

			whereCondition.add(builder.like(qRoot.get("productName"), dto.getProductName() + "%"));
		}

		return whereCondition;
	}

	@Autowired
	ProductDAOInt productDao;

	@Override
	protected void populate(OrderDTO dto, UserContext userContext) {
		if (dto.getProductId() != null && dto.getProductId() > 0) {
			ProductDTO productDto = productDao.findByPK(dto.getProductId(), userContext);
			dto.setProductName(productDto.getName());
			System.out.println(dto.getProductName() + "PriorityName-------");
		}

	}

}
