--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 50
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: my_order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.my_order (
    id smallint,
    customer_id smallint,
    order_number bigint,
    status smallint,
    created_at character varying(19) DEFAULT NULL::character varying,
    address character varying(33) DEFAULT NULL::character varying,
    updated_at character varying(19) DEFAULT NULL::character varying
);


ALTER TABLE public.my_order OWNER TO postgres;

--
-- Name: order_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_item (
    id smallint,
    order_id smallint,
    product_id smallint,
    stock_id smallint,
    amount smallint,
    price integer,
    created_at character varying(19) DEFAULT NULL::character varying,
    updated_at character varying(19) DEFAULT NULL::character varying
);


ALTER TABLE public.order_item OWNER TO postgres;

--
-- Data for Name: my_order; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.my_order (id, customer_id, order_number, status, created_at, address, updated_at) FROM stdin;
14	4	1576041140039	1	2019-12-11 05:12:20	12 Nguyen Trai	2019-12-11 06:59:25
15	4	1576043743158	1	2019-12-11 05:55:43	60 Nguyen Oanh	2019-12-11 05:55:43
16	4	1576044152938	1	2019-12-11 06:02:33	abc	2019-12-11 06:02:52
17	4	1576044295842	1	2019-12-11 06:04:56	cxx	2019-12-11 06:05:17
18	4	1576047980017	1	2019-12-11 07:06:20	210 nguyen trai phuong PNL quan 1	2019-12-11 07:07:55
\.


--
-- Data for Name: order_item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order_item (id, order_id, product_id, stock_id, amount, price, created_at, updated_at) FROM stdin;
17	14	23	15	5	25000000	2019-12-11 05:12:21	2019-12-11 05:12:21
18	15	26	12	10	1200000	2019-12-11 05:55:43	2019-12-11 05:55:43
19	16	21	11	1	20000000	2019-12-11 06:02:33	2019-12-11 06:02:33
20	17	26	12	1	1200000	2019-12-11 06:04:56	2019-12-11 06:04:56
21	18	23	15	3	25000000	2019-12-11 07:06:20	2019-12-11 07:06:20
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 50, false);


--
-- PostgreSQL database dump complete
--

