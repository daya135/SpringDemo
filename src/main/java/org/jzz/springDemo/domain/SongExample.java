package org.jzz.springDemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SongExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SongExample() {
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

        public Criteria andSongidIsNull() {
            addCriterion("songId is null");
            return (Criteria) this;
        }

        public Criteria andSongidIsNotNull() {
            addCriterion("songId is not null");
            return (Criteria) this;
        }

        public Criteria andSongidEqualTo(Integer value) {
            addCriterion("songId =", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidNotEqualTo(Integer value) {
            addCriterion("songId <>", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidGreaterThan(Integer value) {
            addCriterion("songId >", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidGreaterThanOrEqualTo(Integer value) {
            addCriterion("songId >=", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidLessThan(Integer value) {
            addCriterion("songId <", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidLessThanOrEqualTo(Integer value) {
            addCriterion("songId <=", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidIn(List<Integer> values) {
            addCriterion("songId in", values, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidNotIn(List<Integer> values) {
            addCriterion("songId not in", values, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidBetween(Integer value1, Integer value2) {
            addCriterion("songId between", value1, value2, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidNotBetween(Integer value1, Integer value2) {
            addCriterion("songId not between", value1, value2, "songid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andArtistIsNull() {
            addCriterion("artist is null");
            return (Criteria) this;
        }

        public Criteria andArtistIsNotNull() {
            addCriterion("artist is not null");
            return (Criteria) this;
        }

        public Criteria andArtistEqualTo(String value) {
            addCriterion("artist =", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotEqualTo(String value) {
            addCriterion("artist <>", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistGreaterThan(String value) {
            addCriterion("artist >", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistGreaterThanOrEqualTo(String value) {
            addCriterion("artist >=", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistLessThan(String value) {
            addCriterion("artist <", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistLessThanOrEqualTo(String value) {
            addCriterion("artist <=", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistLike(String value) {
            addCriterion("artist like", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotLike(String value) {
            addCriterion("artist not like", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistIn(List<String> values) {
            addCriterion("artist in", values, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotIn(List<String> values) {
            addCriterion("artist not in", values, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistBetween(String value1, String value2) {
            addCriterion("artist between", value1, value2, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotBetween(String value1, String value2) {
            addCriterion("artist not between", value1, value2, "artist");
            return (Criteria) this;
        }

        public Criteria andAlbumIsNull() {
            addCriterion("album is null");
            return (Criteria) this;
        }

        public Criteria andAlbumIsNotNull() {
            addCriterion("album is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumEqualTo(String value) {
            addCriterion("album =", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotEqualTo(String value) {
            addCriterion("album <>", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumGreaterThan(String value) {
            addCriterion("album >", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumGreaterThanOrEqualTo(String value) {
            addCriterion("album >=", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumLessThan(String value) {
            addCriterion("album <", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumLessThanOrEqualTo(String value) {
            addCriterion("album <=", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumLike(String value) {
            addCriterion("album like", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotLike(String value) {
            addCriterion("album not like", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumIn(List<String> values) {
            addCriterion("album in", values, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotIn(List<String> values) {
            addCriterion("album not in", values, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumBetween(String value1, String value2) {
            addCriterion("album between", value1, value2, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotBetween(String value1, String value2) {
            addCriterion("album not between", value1, value2, "album");
            return (Criteria) this;
        }

        public Criteria andBandIsNull() {
            addCriterion("band is null");
            return (Criteria) this;
        }

        public Criteria andBandIsNotNull() {
            addCriterion("band is not null");
            return (Criteria) this;
        }

        public Criteria andBandEqualTo(String value) {
            addCriterion("band =", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandNotEqualTo(String value) {
            addCriterion("band <>", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandGreaterThan(String value) {
            addCriterion("band >", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandGreaterThanOrEqualTo(String value) {
            addCriterion("band >=", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandLessThan(String value) {
            addCriterion("band <", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandLessThanOrEqualTo(String value) {
            addCriterion("band <=", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandLike(String value) {
            addCriterion("band like", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandNotLike(String value) {
            addCriterion("band not like", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandIn(List<String> values) {
            addCriterion("band in", values, "band");
            return (Criteria) this;
        }

        public Criteria andBandNotIn(List<String> values) {
            addCriterion("band not in", values, "band");
            return (Criteria) this;
        }

        public Criteria andBandBetween(String value1, String value2) {
            addCriterion("band between", value1, value2, "band");
            return (Criteria) this;
        }

        public Criteria andBandNotBetween(String value1, String value2) {
            addCriterion("band not between", value1, value2, "band");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(String value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(String value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(String value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(String value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(String value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(String value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLike(String value) {
            addCriterion("rate like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotLike(String value) {
            addCriterion("rate not like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<String> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<String> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(String value1, String value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(String value1, String value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andLenIsNull() {
            addCriterion("len is null");
            return (Criteria) this;
        }

        public Criteria andLenIsNotNull() {
            addCriterion("len is not null");
            return (Criteria) this;
        }

        public Criteria andLenEqualTo(String value) {
            addCriterion("len =", value, "len");
            return (Criteria) this;
        }

        public Criteria andLenNotEqualTo(String value) {
            addCriterion("len <>", value, "len");
            return (Criteria) this;
        }

        public Criteria andLenGreaterThan(String value) {
            addCriterion("len >", value, "len");
            return (Criteria) this;
        }

        public Criteria andLenGreaterThanOrEqualTo(String value) {
            addCriterion("len >=", value, "len");
            return (Criteria) this;
        }

        public Criteria andLenLessThan(String value) {
            addCriterion("len <", value, "len");
            return (Criteria) this;
        }

        public Criteria andLenLessThanOrEqualTo(String value) {
            addCriterion("len <=", value, "len");
            return (Criteria) this;
        }

        public Criteria andLenLike(String value) {
            addCriterion("len like", value, "len");
            return (Criteria) this;
        }

        public Criteria andLenNotLike(String value) {
            addCriterion("len not like", value, "len");
            return (Criteria) this;
        }

        public Criteria andLenIn(List<String> values) {
            addCriterion("len in", values, "len");
            return (Criteria) this;
        }

        public Criteria andLenNotIn(List<String> values) {
            addCriterion("len not in", values, "len");
            return (Criteria) this;
        }

        public Criteria andLenBetween(String value1, String value2) {
            addCriterion("len between", value1, value2, "len");
            return (Criteria) this;
        }

        public Criteria andLenNotBetween(String value1, String value2) {
            addCriterion("len not between", value1, value2, "len");
            return (Criteria) this;
        }

        public Criteria andPublishyearIsNull() {
            addCriterion("publishYear is null");
            return (Criteria) this;
        }

        public Criteria andPublishyearIsNotNull() {
            addCriterion("publishYear is not null");
            return (Criteria) this;
        }

        public Criteria andPublishyearEqualTo(String value) {
            addCriterion("publishYear =", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearNotEqualTo(String value) {
            addCriterion("publishYear <>", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearGreaterThan(String value) {
            addCriterion("publishYear >", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearGreaterThanOrEqualTo(String value) {
            addCriterion("publishYear >=", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearLessThan(String value) {
            addCriterion("publishYear <", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearLessThanOrEqualTo(String value) {
            addCriterion("publishYear <=", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearLike(String value) {
            addCriterion("publishYear like", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearNotLike(String value) {
            addCriterion("publishYear not like", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearIn(List<String> values) {
            addCriterion("publishYear in", values, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearNotIn(List<String> values) {
            addCriterion("publishYear not in", values, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearBetween(String value1, String value2) {
            addCriterion("publishYear between", value1, value2, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearNotBetween(String value1, String value2) {
            addCriterion("publishYear not between", value1, value2, "publishyear");
            return (Criteria) this;
        }

        public Criteria andDownsiteIsNull() {
            addCriterion("downSite is null");
            return (Criteria) this;
        }

        public Criteria andDownsiteIsNotNull() {
            addCriterion("downSite is not null");
            return (Criteria) this;
        }

        public Criteria andDownsiteEqualTo(String value) {
            addCriterion("downSite =", value, "downsite");
            return (Criteria) this;
        }

        public Criteria andDownsiteNotEqualTo(String value) {
            addCriterion("downSite <>", value, "downsite");
            return (Criteria) this;
        }

        public Criteria andDownsiteGreaterThan(String value) {
            addCriterion("downSite >", value, "downsite");
            return (Criteria) this;
        }

        public Criteria andDownsiteGreaterThanOrEqualTo(String value) {
            addCriterion("downSite >=", value, "downsite");
            return (Criteria) this;
        }

        public Criteria andDownsiteLessThan(String value) {
            addCriterion("downSite <", value, "downsite");
            return (Criteria) this;
        }

        public Criteria andDownsiteLessThanOrEqualTo(String value) {
            addCriterion("downSite <=", value, "downsite");
            return (Criteria) this;
        }

        public Criteria andDownsiteLike(String value) {
            addCriterion("downSite like", value, "downsite");
            return (Criteria) this;
        }

        public Criteria andDownsiteNotLike(String value) {
            addCriterion("downSite not like", value, "downsite");
            return (Criteria) this;
        }

        public Criteria andDownsiteIn(List<String> values) {
            addCriterion("downSite in", values, "downsite");
            return (Criteria) this;
        }

        public Criteria andDownsiteNotIn(List<String> values) {
            addCriterion("downSite not in", values, "downsite");
            return (Criteria) this;
        }

        public Criteria andDownsiteBetween(String value1, String value2) {
            addCriterion("downSite between", value1, value2, "downsite");
            return (Criteria) this;
        }

        public Criteria andDownsiteNotBetween(String value1, String value2) {
            addCriterion("downSite not between", value1, value2, "downsite");
            return (Criteria) this;
        }

        public Criteria andOnsaleIsNull() {
            addCriterion("onsale is null");
            return (Criteria) this;
        }

        public Criteria andOnsaleIsNotNull() {
            addCriterion("onsale is not null");
            return (Criteria) this;
        }

        public Criteria andOnsaleEqualTo(String value) {
            addCriterion("onsale =", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleNotEqualTo(String value) {
            addCriterion("onsale <>", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleGreaterThan(String value) {
            addCriterion("onsale >", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleGreaterThanOrEqualTo(String value) {
            addCriterion("onsale >=", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleLessThan(String value) {
            addCriterion("onsale <", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleLessThanOrEqualTo(String value) {
            addCriterion("onsale <=", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleLike(String value) {
            addCriterion("onsale like", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleNotLike(String value) {
            addCriterion("onsale not like", value, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleIn(List<String> values) {
            addCriterion("onsale in", values, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleNotIn(List<String> values) {
            addCriterion("onsale not in", values, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleBetween(String value1, String value2) {
            addCriterion("onsale between", value1, value2, "onsale");
            return (Criteria) this;
        }

        public Criteria andOnsaleNotBetween(String value1, String value2) {
            addCriterion("onsale not between", value1, value2, "onsale");
            return (Criteria) this;
        }

        public Criteria andLangtypeIsNull() {
            addCriterion("langType is null");
            return (Criteria) this;
        }

        public Criteria andLangtypeIsNotNull() {
            addCriterion("langType is not null");
            return (Criteria) this;
        }

        public Criteria andLangtypeEqualTo(String value) {
            addCriterion("langType =", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeNotEqualTo(String value) {
            addCriterion("langType <>", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeGreaterThan(String value) {
            addCriterion("langType >", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeGreaterThanOrEqualTo(String value) {
            addCriterion("langType >=", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeLessThan(String value) {
            addCriterion("langType <", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeLessThanOrEqualTo(String value) {
            addCriterion("langType <=", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeLike(String value) {
            addCriterion("langType like", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeNotLike(String value) {
            addCriterion("langType not like", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeIn(List<String> values) {
            addCriterion("langType in", values, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeNotIn(List<String> values) {
            addCriterion("langType not in", values, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeBetween(String value1, String value2) {
            addCriterion("langType between", value1, value2, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeNotBetween(String value1, String value2) {
            addCriterion("langType not between", value1, value2, "langtype");
            return (Criteria) this;
        }

        public Criteria andFiletypeIsNull() {
            addCriterion("fileType is null");
            return (Criteria) this;
        }

        public Criteria andFiletypeIsNotNull() {
            addCriterion("fileType is not null");
            return (Criteria) this;
        }

        public Criteria andFiletypeEqualTo(String value) {
            addCriterion("fileType =", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotEqualTo(String value) {
            addCriterion("fileType <>", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeGreaterThan(String value) {
            addCriterion("fileType >", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeGreaterThanOrEqualTo(String value) {
            addCriterion("fileType >=", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLessThan(String value) {
            addCriterion("fileType <", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLessThanOrEqualTo(String value) {
            addCriterion("fileType <=", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLike(String value) {
            addCriterion("fileType like", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotLike(String value) {
            addCriterion("fileType not like", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeIn(List<String> values) {
            addCriterion("fileType in", values, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotIn(List<String> values) {
            addCriterion("fileType not in", values, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeBetween(String value1, String value2) {
            addCriterion("fileType between", value1, value2, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotBetween(String value1, String value2) {
            addCriterion("fileType not between", value1, value2, "filetype");
            return (Criteria) this;
        }

        public Criteria andIsdownloadIsNull() {
            addCriterion("isDownload is null");
            return (Criteria) this;
        }

        public Criteria andIsdownloadIsNotNull() {
            addCriterion("isDownload is not null");
            return (Criteria) this;
        }

        public Criteria andIsdownloadEqualTo(String value) {
            addCriterion("isDownload =", value, "isdownload");
            return (Criteria) this;
        }

        public Criteria andIsdownloadNotEqualTo(String value) {
            addCriterion("isDownload <>", value, "isdownload");
            return (Criteria) this;
        }

        public Criteria andIsdownloadGreaterThan(String value) {
            addCriterion("isDownload >", value, "isdownload");
            return (Criteria) this;
        }

        public Criteria andIsdownloadGreaterThanOrEqualTo(String value) {
            addCriterion("isDownload >=", value, "isdownload");
            return (Criteria) this;
        }

        public Criteria andIsdownloadLessThan(String value) {
            addCriterion("isDownload <", value, "isdownload");
            return (Criteria) this;
        }

        public Criteria andIsdownloadLessThanOrEqualTo(String value) {
            addCriterion("isDownload <=", value, "isdownload");
            return (Criteria) this;
        }

        public Criteria andIsdownloadLike(String value) {
            addCriterion("isDownload like", value, "isdownload");
            return (Criteria) this;
        }

        public Criteria andIsdownloadNotLike(String value) {
            addCriterion("isDownload not like", value, "isdownload");
            return (Criteria) this;
        }

        public Criteria andIsdownloadIn(List<String> values) {
            addCriterion("isDownload in", values, "isdownload");
            return (Criteria) this;
        }

        public Criteria andIsdownloadNotIn(List<String> values) {
            addCriterion("isDownload not in", values, "isdownload");
            return (Criteria) this;
        }

        public Criteria andIsdownloadBetween(String value1, String value2) {
            addCriterion("isDownload between", value1, value2, "isdownload");
            return (Criteria) this;
        }

        public Criteria andIsdownloadNotBetween(String value1, String value2) {
            addCriterion("isDownload not between", value1, value2, "isdownload");
            return (Criteria) this;
        }

        public Criteria andLocalpathIsNull() {
            addCriterion("localPath is null");
            return (Criteria) this;
        }

        public Criteria andLocalpathIsNotNull() {
            addCriterion("localPath is not null");
            return (Criteria) this;
        }

        public Criteria andLocalpathEqualTo(String value) {
            addCriterion("localPath =", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathNotEqualTo(String value) {
            addCriterion("localPath <>", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathGreaterThan(String value) {
            addCriterion("localPath >", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathGreaterThanOrEqualTo(String value) {
            addCriterion("localPath >=", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathLessThan(String value) {
            addCriterion("localPath <", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathLessThanOrEqualTo(String value) {
            addCriterion("localPath <=", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathLike(String value) {
            addCriterion("localPath like", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathNotLike(String value) {
            addCriterion("localPath not like", value, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathIn(List<String> values) {
            addCriterion("localPath in", values, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathNotIn(List<String> values) {
            addCriterion("localPath not in", values, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathBetween(String value1, String value2) {
            addCriterion("localPath between", value1, value2, "localpath");
            return (Criteria) this;
        }

        public Criteria andLocalpathNotBetween(String value1, String value2) {
            addCriterion("localPath not between", value1, value2, "localpath");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
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