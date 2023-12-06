package com.microservice.Orderservice.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="order_line_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderLineItems {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String skuCode;
	private Double price;
	private Long quantity;
	
}
