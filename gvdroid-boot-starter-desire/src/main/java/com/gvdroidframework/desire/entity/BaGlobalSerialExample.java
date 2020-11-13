package com.gvdroidframework.desire.entity;

import java.util.ArrayList;
import java.util.List;

public class BaGlobalSerialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaGlobalSerialExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyIsNull() {
            addCriterion("sequenceKey is null");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyIsNotNull() {
            addCriterion("sequenceKey is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyEqualTo(String value) {
            addCriterion("sequenceKey =", value, "sequenceKey");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyNotEqualTo(String value) {
            addCriterion("sequenceKey <>", value, "sequenceKey");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyGreaterThan(String value) {
            addCriterion("sequenceKey >", value, "sequenceKey");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyGreaterThanOrEqualTo(String value) {
            addCriterion("sequenceKey >=", value, "sequenceKey");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyLessThan(String value) {
            addCriterion("sequenceKey <", value, "sequenceKey");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyLessThanOrEqualTo(String value) {
            addCriterion("sequenceKey <=", value, "sequenceKey");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyLike(String value) {
            addCriterion("sequenceKey like", value, "sequenceKey");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyNotLike(String value) {
            addCriterion("sequenceKey not like", value, "sequenceKey");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyIn(List<String> values) {
            addCriterion("sequenceKey in", values, "sequenceKey");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyNotIn(List<String> values) {
            addCriterion("sequenceKey not in", values, "sequenceKey");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyBetween(String value1, String value2) {
            addCriterion("sequenceKey between", value1, value2, "sequenceKey");
            return (Criteria) this;
        }

        public Criteria andSequenceKeyNotBetween(String value1, String value2) {
            addCriterion("sequenceKey not between", value1, value2, "sequenceKey");
            return (Criteria) this;
        }

        public Criteria andSequenceValueIsNull() {
            addCriterion("sequenceValue is null");
            return (Criteria) this;
        }

        public Criteria andSequenceValueIsNotNull() {
            addCriterion("sequenceValue is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceValueEqualTo(Integer value) {
            addCriterion("sequenceValue =", value, "sequenceValue");
            return (Criteria) this;
        }

        public Criteria andSequenceValueNotEqualTo(Integer value) {
            addCriterion("sequenceValue <>", value, "sequenceValue");
            return (Criteria) this;
        }

        public Criteria andSequenceValueGreaterThan(Integer value) {
            addCriterion("sequenceValue >", value, "sequenceValue");
            return (Criteria) this;
        }

        public Criteria andSequenceValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequenceValue >=", value, "sequenceValue");
            return (Criteria) this;
        }

        public Criteria andSequenceValueLessThan(Integer value) {
            addCriterion("sequenceValue <", value, "sequenceValue");
            return (Criteria) this;
        }

        public Criteria andSequenceValueLessThanOrEqualTo(Integer value) {
            addCriterion("sequenceValue <=", value, "sequenceValue");
            return (Criteria) this;
        }

        public Criteria andSequenceValueIn(List<Integer> values) {
            addCriterion("sequenceValue in", values, "sequenceValue");
            return (Criteria) this;
        }

        public Criteria andSequenceValueNotIn(List<Integer> values) {
            addCriterion("sequenceValue not in", values, "sequenceValue");
            return (Criteria) this;
        }

        public Criteria andSequenceValueBetween(Integer value1, Integer value2) {
            addCriterion("sequenceValue between", value1, value2, "sequenceValue");
            return (Criteria) this;
        }

        public Criteria andSequenceValueNotBetween(Integer value1, Integer value2) {
            addCriterion("sequenceValue not between", value1, value2, "sequenceValue");
            return (Criteria) this;
        }

        public Criteria andSequenceDateIsNull() {
            addCriterion("sequenceDate is null");
            return (Criteria) this;
        }

        public Criteria andSequenceDateIsNotNull() {
            addCriterion("sequenceDate is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceDateEqualTo(String value) {
            addCriterion("sequenceDate =", value, "sequenceDate");
            return (Criteria) this;
        }

        public Criteria andSequenceDateNotEqualTo(String value) {
            addCriterion("sequenceDate <>", value, "sequenceDate");
            return (Criteria) this;
        }

        public Criteria andSequenceDateGreaterThan(String value) {
            addCriterion("sequenceDate >", value, "sequenceDate");
            return (Criteria) this;
        }

        public Criteria andSequenceDateGreaterThanOrEqualTo(String value) {
            addCriterion("sequenceDate >=", value, "sequenceDate");
            return (Criteria) this;
        }

        public Criteria andSequenceDateLessThan(String value) {
            addCriterion("sequenceDate <", value, "sequenceDate");
            return (Criteria) this;
        }

        public Criteria andSequenceDateLessThanOrEqualTo(String value) {
            addCriterion("sequenceDate <=", value, "sequenceDate");
            return (Criteria) this;
        }

        public Criteria andSequenceDateLike(String value) {
            addCriterion("sequenceDate like", value, "sequenceDate");
            return (Criteria) this;
        }

        public Criteria andSequenceDateNotLike(String value) {
            addCriterion("sequenceDate not like", value, "sequenceDate");
            return (Criteria) this;
        }

        public Criteria andSequenceDateIn(List<String> values) {
            addCriterion("sequenceDate in", values, "sequenceDate");
            return (Criteria) this;
        }

        public Criteria andSequenceDateNotIn(List<String> values) {
            addCriterion("sequenceDate not in", values, "sequenceDate");
            return (Criteria) this;
        }

        public Criteria andSequenceDateBetween(String value1, String value2) {
            addCriterion("sequenceDate between", value1, value2, "sequenceDate");
            return (Criteria) this;
        }

        public Criteria andSequenceDateNotBetween(String value1, String value2) {
            addCriterion("sequenceDate not between", value1, value2, "sequenceDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}