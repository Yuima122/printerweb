package com.printer.pojo;

import java.util.ArrayList;
import java.util.List;

public class FileinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FileinfoExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("orderid like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("orderid not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andSavenameIsNull() {
            addCriterion("savename is null");
            return (Criteria) this;
        }

        public Criteria andSavenameIsNotNull() {
            addCriterion("savename is not null");
            return (Criteria) this;
        }

        public Criteria andSavenameEqualTo(String value) {
            addCriterion("savename =", value, "savename");
            return (Criteria) this;
        }

        public Criteria andSavenameNotEqualTo(String value) {
            addCriterion("savename <>", value, "savename");
            return (Criteria) this;
        }

        public Criteria andSavenameGreaterThan(String value) {
            addCriterion("savename >", value, "savename");
            return (Criteria) this;
        }

        public Criteria andSavenameGreaterThanOrEqualTo(String value) {
            addCriterion("savename >=", value, "savename");
            return (Criteria) this;
        }

        public Criteria andSavenameLessThan(String value) {
            addCriterion("savename <", value, "savename");
            return (Criteria) this;
        }

        public Criteria andSavenameLessThanOrEqualTo(String value) {
            addCriterion("savename <=", value, "savename");
            return (Criteria) this;
        }

        public Criteria andSavenameLike(String value) {
            addCriterion("savename like", value, "savename");
            return (Criteria) this;
        }

        public Criteria andSavenameNotLike(String value) {
            addCriterion("savename not like", value, "savename");
            return (Criteria) this;
        }

        public Criteria andSavenameIn(List<String> values) {
            addCriterion("savename in", values, "savename");
            return (Criteria) this;
        }

        public Criteria andSavenameNotIn(List<String> values) {
            addCriterion("savename not in", values, "savename");
            return (Criteria) this;
        }

        public Criteria andSavenameBetween(String value1, String value2) {
            addCriterion("savename between", value1, value2, "savename");
            return (Criteria) this;
        }

        public Criteria andSavenameNotBetween(String value1, String value2) {
            addCriterion("savename not between", value1, value2, "savename");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andDanIsNull() {
            addCriterion("dan is null");
            return (Criteria) this;
        }

        public Criteria andDanIsNotNull() {
            addCriterion("dan is not null");
            return (Criteria) this;
        }

        public Criteria andDanEqualTo(Integer value) {
            addCriterion("dan =", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanNotEqualTo(Integer value) {
            addCriterion("dan <>", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanGreaterThan(Integer value) {
            addCriterion("dan >", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanGreaterThanOrEqualTo(Integer value) {
            addCriterion("dan >=", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanLessThan(Integer value) {
            addCriterion("dan <", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanLessThanOrEqualTo(Integer value) {
            addCriterion("dan <=", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanIn(List<Integer> values) {
            addCriterion("dan in", values, "dan");
            return (Criteria) this;
        }

        public Criteria andDanNotIn(List<Integer> values) {
            addCriterion("dan not in", values, "dan");
            return (Criteria) this;
        }

        public Criteria andDanBetween(Integer value1, Integer value2) {
            addCriterion("dan between", value1, value2, "dan");
            return (Criteria) this;
        }

        public Criteria andDanNotBetween(Integer value1, Integer value2) {
            addCriterion("dan not between", value1, value2, "dan");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(Integer value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(Integer value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(Integer value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(Integer value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(Integer value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(Integer value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<Integer> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<Integer> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(Integer value1, Integer value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(Integer value1, Integer value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andRangestartIsNull() {
            addCriterion("rangestart is null");
            return (Criteria) this;
        }

        public Criteria andRangestartIsNotNull() {
            addCriterion("rangestart is not null");
            return (Criteria) this;
        }

        public Criteria andRangestartEqualTo(Integer value) {
            addCriterion("rangestart =", value, "rangestart");
            return (Criteria) this;
        }

        public Criteria andRangestartNotEqualTo(Integer value) {
            addCriterion("rangestart <>", value, "rangestart");
            return (Criteria) this;
        }

        public Criteria andRangestartGreaterThan(Integer value) {
            addCriterion("rangestart >", value, "rangestart");
            return (Criteria) this;
        }

        public Criteria andRangestartGreaterThanOrEqualTo(Integer value) {
            addCriterion("rangestart >=", value, "rangestart");
            return (Criteria) this;
        }

        public Criteria andRangestartLessThan(Integer value) {
            addCriterion("rangestart <", value, "rangestart");
            return (Criteria) this;
        }

        public Criteria andRangestartLessThanOrEqualTo(Integer value) {
            addCriterion("rangestart <=", value, "rangestart");
            return (Criteria) this;
        }

        public Criteria andRangestartIn(List<Integer> values) {
            addCriterion("rangestart in", values, "rangestart");
            return (Criteria) this;
        }

        public Criteria andRangestartNotIn(List<Integer> values) {
            addCriterion("rangestart not in", values, "rangestart");
            return (Criteria) this;
        }

        public Criteria andRangestartBetween(Integer value1, Integer value2) {
            addCriterion("rangestart between", value1, value2, "rangestart");
            return (Criteria) this;
        }

        public Criteria andRangestartNotBetween(Integer value1, Integer value2) {
            addCriterion("rangestart not between", value1, value2, "rangestart");
            return (Criteria) this;
        }

        public Criteria andRangeendIsNull() {
            addCriterion("rangeend is null");
            return (Criteria) this;
        }

        public Criteria andRangeendIsNotNull() {
            addCriterion("rangeend is not null");
            return (Criteria) this;
        }

        public Criteria andRangeendEqualTo(Integer value) {
            addCriterion("rangeend =", value, "rangeend");
            return (Criteria) this;
        }

        public Criteria andRangeendNotEqualTo(Integer value) {
            addCriterion("rangeend <>", value, "rangeend");
            return (Criteria) this;
        }

        public Criteria andRangeendGreaterThan(Integer value) {
            addCriterion("rangeend >", value, "rangeend");
            return (Criteria) this;
        }

        public Criteria andRangeendGreaterThanOrEqualTo(Integer value) {
            addCriterion("rangeend >=", value, "rangeend");
            return (Criteria) this;
        }

        public Criteria andRangeendLessThan(Integer value) {
            addCriterion("rangeend <", value, "rangeend");
            return (Criteria) this;
        }

        public Criteria andRangeendLessThanOrEqualTo(Integer value) {
            addCriterion("rangeend <=", value, "rangeend");
            return (Criteria) this;
        }

        public Criteria andRangeendIn(List<Integer> values) {
            addCriterion("rangeend in", values, "rangeend");
            return (Criteria) this;
        }

        public Criteria andRangeendNotIn(List<Integer> values) {
            addCriterion("rangeend not in", values, "rangeend");
            return (Criteria) this;
        }

        public Criteria andRangeendBetween(Integer value1, Integer value2) {
            addCriterion("rangeend between", value1, value2, "rangeend");
            return (Criteria) this;
        }

        public Criteria andRangeendNotBetween(Integer value1, Integer value2) {
            addCriterion("rangeend not between", value1, value2, "rangeend");
            return (Criteria) this;
        }

        public Criteria andAllinoneIsNull() {
            addCriterion("allinone is null");
            return (Criteria) this;
        }

        public Criteria andAllinoneIsNotNull() {
            addCriterion("allinone is not null");
            return (Criteria) this;
        }

        public Criteria andAllinoneEqualTo(Integer value) {
            addCriterion("allinone =", value, "allinone");
            return (Criteria) this;
        }

        public Criteria andAllinoneNotEqualTo(Integer value) {
            addCriterion("allinone <>", value, "allinone");
            return (Criteria) this;
        }

        public Criteria andAllinoneGreaterThan(Integer value) {
            addCriterion("allinone >", value, "allinone");
            return (Criteria) this;
        }

        public Criteria andAllinoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("allinone >=", value, "allinone");
            return (Criteria) this;
        }

        public Criteria andAllinoneLessThan(Integer value) {
            addCriterion("allinone <", value, "allinone");
            return (Criteria) this;
        }

        public Criteria andAllinoneLessThanOrEqualTo(Integer value) {
            addCriterion("allinone <=", value, "allinone");
            return (Criteria) this;
        }

        public Criteria andAllinoneIn(List<Integer> values) {
            addCriterion("allinone in", values, "allinone");
            return (Criteria) this;
        }

        public Criteria andAllinoneNotIn(List<Integer> values) {
            addCriterion("allinone not in", values, "allinone");
            return (Criteria) this;
        }

        public Criteria andAllinoneBetween(Integer value1, Integer value2) {
            addCriterion("allinone between", value1, value2, "allinone");
            return (Criteria) this;
        }

        public Criteria andAllinoneNotBetween(Integer value1, Integer value2) {
            addCriterion("allinone not between", value1, value2, "allinone");
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