package com.cleverpost.admin.common.enums;

public enum OrderStatuses {

	WAITING_FOR_APPLY("Waiting for apply", 1l), 
	PREPARING("Preparing", 2l), 
	COMPLETE("Complete", 3l), 
	CANCELLED("Cancelled", 4l);

	private String value;

	private Long id;

	private OrderStatuses(String value, Long id) {
		this.setValue(value);
		this.setId(id);
	}

	public static OrderStatuses get(Long id) {
		for (OrderStatuses item : OrderStatuses.values()) {
			if (item.getId().equals(id)) {
				return item;
			}
		}

		return null;
	}

	public static OrderStatuses get(String id) {
		for (OrderStatuses item : OrderStatuses.values()) {
			if (item.getValue().equals(id)) {
				return item;
			}
		}

		return null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.getValue();
	}

}
