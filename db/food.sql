--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: food; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA food;


ALTER SCHEMA food OWNER TO postgres;

SET search_path = food, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: client; Type: TABLE; Schema: food; Owner: postgres
--

CREATE TABLE client (
    cid integer NOT NULL,
    name character varying(50),
    credential character varying(50),
    email character varying(50),
    phone character varying(20),
    height integer,
    weight integer
);


ALTER TABLE client OWNER TO postgres;

--
-- Name: client_cid_seq; Type: SEQUENCE; Schema: food; Owner: postgres
--

CREATE SEQUENCE client_cid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE client_cid_seq OWNER TO postgres;

--
-- Name: client_cid_seq; Type: SEQUENCE OWNED BY; Schema: food; Owner: postgres
--

ALTER SEQUENCE client_cid_seq OWNED BY client.cid;


--
-- Name: menu; Type: TABLE; Schema: food; Owner: postgres
--

CREATE TABLE menu (
    mid integer NOT NULL,
    name character varying(50),
    price double precision,
    rid integer,
    image character varying(20),
    calory integer DEFAULT 0
);


ALTER TABLE menu OWNER TO postgres;

--
-- Name: menu_mid_seq; Type: SEQUENCE; Schema: food; Owner: postgres
--

CREATE SEQUENCE menu_mid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE menu_mid_seq OWNER TO postgres;

--
-- Name: menu_mid_seq; Type: SEQUENCE OWNED BY; Schema: food; Owner: postgres
--

ALTER SEQUENCE menu_mid_seq OWNED BY menu.mid;


--
-- Name: restaurant; Type: TABLE; Schema: food; Owner: postgres
--

CREATE TABLE restaurant (
    rid integer NOT NULL,
    name character varying(50),
    address character varying(50),
    phone character varying(20),
    postalcode character varying(10),
    image character varying(20),
    email character varying(50),
    website character varying(100)
);


ALTER TABLE restaurant OWNER TO postgres;

--
-- Name: restaurant_rid_seq; Type: SEQUENCE; Schema: food; Owner: postgres
--

CREATE SEQUENCE restaurant_rid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE restaurant_rid_seq OWNER TO postgres;

--
-- Name: restaurant_rid_seq; Type: SEQUENCE OWNED BY; Schema: food; Owner: postgres
--

ALTER SEQUENCE restaurant_rid_seq OWNED BY restaurant.rid;


--
-- Name: tag; Type: TABLE; Schema: food; Owner: postgres
--

CREATE TABLE tag (
    tid integer NOT NULL,
    name character varying(20)
);


ALTER TABLE tag OWNER TO postgres;

--
-- Name: tag_tid_seq; Type: SEQUENCE; Schema: food; Owner: postgres
--

CREATE SEQUENCE tag_tid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tag_tid_seq OWNER TO postgres;

--
-- Name: tag_tid_seq; Type: SEQUENCE OWNED BY; Schema: food; Owner: postgres
--

ALTER SEQUENCE tag_tid_seq OWNED BY tag.tid;


--
-- Name: tagging; Type: TABLE; Schema: food; Owner: postgres
--

CREATE TABLE tagging (
    gid bigint NOT NULL,
    tid integer,
    mid integer,
    cid integer,
    rate integer DEFAULT 0,
    tag_date bigint
);


ALTER TABLE tagging OWNER TO postgres;

--
-- Name: tagging_gid_seq; Type: SEQUENCE; Schema: food; Owner: postgres
--

CREATE SEQUENCE tagging_gid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tagging_gid_seq OWNER TO postgres;

--
-- Name: tagging_gid_seq; Type: SEQUENCE OWNED BY; Schema: food; Owner: postgres
--

ALTER SEQUENCE tagging_gid_seq OWNED BY tagging.gid;


--
-- Name: cid; Type: DEFAULT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY client ALTER COLUMN cid SET DEFAULT nextval('client_cid_seq'::regclass);


--
-- Name: mid; Type: DEFAULT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY menu ALTER COLUMN mid SET DEFAULT nextval('menu_mid_seq'::regclass);


--
-- Name: rid; Type: DEFAULT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY restaurant ALTER COLUMN rid SET DEFAULT nextval('restaurant_rid_seq'::regclass);


--
-- Name: tid; Type: DEFAULT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY tag ALTER COLUMN tid SET DEFAULT nextval('tag_tid_seq'::regclass);


--
-- Name: gid; Type: DEFAULT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY tagging ALTER COLUMN gid SET DEFAULT nextval('tagging_gid_seq'::regclass);


--
-- Data for Name: client; Type: TABLE DATA; Schema: food; Owner: postgres
--

COPY client (cid, name, credential, email, phone, height, weight) FROM stdin;
\.


--
-- Name: client_cid_seq; Type: SEQUENCE SET; Schema: food; Owner: postgres
--

SELECT pg_catalog.setval('client_cid_seq', 114, true);


--
-- Data for Name: menu; Type: TABLE DATA; Schema: food; Owner: postgres
--

COPY menu (mid, name, price, rid, image, calory) FROM stdin;
35	Beef Burger	10	1	Burger1.jpg	0
36	Chicken Burger	10	1	Burger2.jpg	0
37	Beef Burger Combo	10	1	Burger3.jpeg	0
38	BigMac	10	1	Burger5.jpg	0
39	Beacon Burger	10	1	Burger6.jpg	0
40	Poutine	10	1	Burger7.jpg	0
41	Chicken Wings	10	1	Chickenwings.jpg	0
42	Cheese Burger	10	1	Burger10.jpg	0
43	Curry Shrimp Noodles	10	1	Gw35Cj.png	0
44	Duck Noodles	10	2	wWbyPf.png	0
45	Hot Fish	10	2	m7Ox9f.png	0
46	Huiguorou	10	2	sERJWG.jpeg	0
47	Japanese Beef Hotpot	10	2	BibmYC.png	0
48	Korean Fried Chicken	10	2	9GTO6O.png	0
49	Korean ZhaJiangMian	10	2	ZJejGo.png	0
50	Mushroom Chicken	10	2	daAd0l.png	0
51	Octopus Noodles	10	3	T9bF6R.png	0
52	Pancake	10	3	Gr17xM.png	0
53	Pizza	10	3	GTfKc3.png	0
54	Sandwish	10	3	T3shHI.png	0
55	Sashimi	10	3	wM4WMu.png	0
56	Seasonal Bean	10	3	G8pJYn.png	0
57	Spicy Tofu	10	3	nGeo7Y.png	0
58	Sushi	10	3	BnrHVS.png	0
59	Sweet Sour Chicken	10	3	S3EOSq.png	0
60	ThaiNoodles	10	3	vWkJRk.png	0
2	Onion Ring	6	1	OnionRoll9.jpg	0
3	Egg & Salad	8	3	bf3.jpg	0
4	Beef bread	10	2	bf4.jpg	0
5	Cheese egg	10	2	bf5.jpg	0
7	Tomato fried egg	10	3	bf7.jpg	0
6	Silk	30	3	bf6.jpg	0
1	Bacon fried egg	5	1	bf1.jpg	0
8	Good morning	10	1	bf8.jpeg	0
\.


--
-- Name: menu_mid_seq; Type: SEQUENCE SET; Schema: food; Owner: postgres
--

SELECT pg_catalog.setval('menu_mid_seq', 171, true);


--
-- Data for Name: restaurant; Type: TABLE DATA; Schema: food; Owner: postgres
--

COPY restaurant (rid, name, address, phone, postalcode, image, email, website) FROM stdin;
2	Saigon House	2169 Wyandotte Street	12045099433	N9C2M3	saigonhouse.png	\N	\N
1	Harveys	2380 Wyandotte Street	12045099864	N9C2M3	harveys.png	\N	\N
3	Windsor Seoul	2050 Wyandotte Street	15195099433	N9C2M3	seoul.png	\N	\N
\.


--
-- Name: restaurant_rid_seq; Type: SEQUENCE SET; Schema: food; Owner: postgres
--

SELECT pg_catalog.setval('restaurant_rid_seq', 174, true);


--
-- Data for Name: tag; Type: TABLE DATA; Schema: food; Owner: postgres
--

COPY tag (tid, name) FROM stdin;
1	breakfast
2	lunch
3	dinner
4	Spicy
5	Juicy
6	Halal
7	Teriyaki
8	Cajun
9	Pepper
\.


--
-- Name: tag_tid_seq; Type: SEQUENCE SET; Schema: food; Owner: postgres
--

SELECT pg_catalog.setval('tag_tid_seq', 133, true);


--
-- Data for Name: tagging; Type: TABLE DATA; Schema: food; Owner: postgres
--

COPY tagging (gid, tid, mid, cid, rate, tag_date) FROM stdin;
13	4	45	\N	0	\N
14	4	47	\N	0	\N
9	5	35	\N	0	\N
10	5	36	\N	0	\N
11	5	37	\N	0	\N
12	5	38	\N	0	\N
36	2	38	\N	0	\N
37	2	39	\N	0	\N
38	2	46	\N	0	\N
39	2	47	\N	0	\N
40	2	54	\N	0	\N
41	2	55	\N	0	\N
42	3	40	\N	0	\N
43	3	41	\N	0	\N
44	3	42	\N	0	\N
45	3	43	\N	0	\N
46	3	48	\N	0	\N
47	3	49	\N	0	\N
48	3	50	\N	0	\N
49	3	56	\N	0	\N
50	3	57	\N	0	\N
51	3	58	\N	0	\N
52	3	59	\N	0	\N
53	3	60	\N	0	\N
1	1	1	\N	0	\N
2	1	2	\N	0	\N
3	1	3	\N	0	\N
4	1	4	\N	0	\N
5	1	5	\N	0	\N
6	1	6	\N	0	\N
7	1	7	\N	0	\N
8	1	8	\N	0	\N
28	2	35	\N	0	\N
29	2	36	\N	0	\N
30	2	37	\N	0	\N
31	3	44	\N	0	\N
32	3	45	\N	0	\N
33	3	51	\N	0	\N
34	3	52	\N	0	\N
35	3	53	\N	0	\N
15	6	50	\N	5	\N
16	6	55	\N	5	\N
17	7	50	\N	5	\N
18	7	41	\N	5	\N
19	9	2	\N	5	\N
20	7	40	\N	5	\N
21	7	43	\N	5	\N
22	7	46	\N	5	\N
23	5	46	\N	5	\N
\.


--
-- Name: tagging_gid_seq; Type: SEQUENCE SET; Schema: food; Owner: postgres
--

SELECT pg_catalog.setval('tagging_gid_seq', 121, true);


--
-- Name: client_pkey; Type: CONSTRAINT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_pkey PRIMARY KEY (cid);


--
-- Name: menu_pkey; Type: CONSTRAINT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (mid);


--
-- Name: restaurant_pkey; Type: CONSTRAINT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY restaurant
    ADD CONSTRAINT restaurant_pkey PRIMARY KEY (rid);


--
-- Name: tag_pkey; Type: CONSTRAINT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY tag
    ADD CONSTRAINT tag_pkey PRIMARY KEY (tid);


--
-- Name: tagging_pkey; Type: CONSTRAINT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY tagging
    ADD CONSTRAINT tagging_pkey PRIMARY KEY (gid);


--
-- Name: menu_rid_fkey; Type: FK CONSTRAINT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY menu
    ADD CONSTRAINT menu_rid_fkey FOREIGN KEY (rid) REFERENCES restaurant(rid);


--
-- Name: tagging_cid_fkey; Type: FK CONSTRAINT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY tagging
    ADD CONSTRAINT tagging_cid_fkey FOREIGN KEY (cid) REFERENCES client(cid);


--
-- Name: tagging_mid_fkey; Type: FK CONSTRAINT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY tagging
    ADD CONSTRAINT tagging_mid_fkey FOREIGN KEY (mid) REFERENCES menu(mid);


--
-- Name: tagging_tid_fkey; Type: FK CONSTRAINT; Schema: food; Owner: postgres
--

ALTER TABLE ONLY tagging
    ADD CONSTRAINT tagging_tid_fkey FOREIGN KEY (tid) REFERENCES tag(tid);


--
-- PostgreSQL database dump complete
--

