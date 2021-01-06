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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    id smallint,
    name character varying(16) DEFAULT NULL::character varying,
    email character varying(27) DEFAULT NULL::character varying,
    phone character varying(10) DEFAULT NULL::character varying,
    created_at character varying(19) DEFAULT NULL::character varying,
    updated_at character varying(19) DEFAULT NULL::character varying
);


ALTER TABLE public.customer OWNER TO postgres;

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

--
-- Name: my_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.my_user (
    id smallint,
    customer_id smallint,
    username character varying(9) DEFAULT NULL::character varying,
    password character varying(60) DEFAULT NULL::character varying,
    role smallint,
    created_at character varying(19) DEFAULT NULL::character varying,
    updated_at character varying(19) DEFAULT NULL::character varying
);


ALTER TABLE public.my_user OWNER TO postgres;

--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (id, name, email, phone, created_at, updated_at) FROM stdin;
1	minh khoi 	mail@gmail.com	0707333124	2019-03-20 00:00:00	2019-10-11 11:22:38
2	long 2 2 2	longvl@gmail.com	7896541dsa	2019-03-21 00:00:00	2019-10-11 07:16:18
3	Khoa Minh	abc@abc.com	0987654321	2019-11-20 04:01:04	2019-11-20 04:01:04
4	Khoa Minh	abc@abc.com	0987654321	2019-11-20 04:04:48	2019-11-20 04:04:48
5	Nguyen Minh Khoi	nguyeninhkhoi.red@gmail.com	0707333124	2019-12-11 07:05:19	2019-12-11 07:05:19
6	Nguyen Minh Khoi	mail@gmail.com.vn	0707333124	2019-12-26 15:42:28	2019-12-26 15:42:28
\.


--
-- Data for Name: my_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.my_user (id, customer_id, username, password, role, created_at, updated_at) FROM stdin;
1	0	seller	$2a$10$QzYd5ZOv.cMItqhrIGTsMOyvhEoNIKbQ3ZMRJ1./23rwmAPoFGvvG	1	2019-03-20 00:00:00	2019-03-20 00:00:00
7	0	admin	$2a$10$QzYd5ZOv.cMItqhrIGTsMOyvhEoNIKbQ3ZMRJ1./23rwmAPoFGvvG	0	2019-10-11 05:37:08	2019-10-11 05:37:08
8	4	minhkhoa	$2a$10$QzYd5ZOv.cMItqhrIGTsMOyvhEoNIKbQ3ZMRJ1./23rwmAPoFGvvG	1	2019-11-20 04:05:22	2019-11-20 04:05:22
9	0	stocker	$2a$10$QzYd5ZOv.cMItqhrIGTsMOyvhEoNIKbQ3ZMRJ1./23rwmAPoFGvvG	1	2019-12-04 00:00:00	2019-12-04 00:00:00
10	5	minhkhoi	$2a$10$DcQ6ZJULDU81NvOMF.8i2OuRbH5iJmBT0i7ypziz/UWfvpKAbciF.	1	2019-12-11 07:05:19	2019-12-11 07:05:19
11	6	minhkhoi2	$2a$10$QzYd5ZOv.cMItqhrIGTsMOyvhEoNIKbQ3ZMRJ1./23rwmAPoFGvvG	1	2019-12-26 15:42:28	2019-12-26 15:42:28
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 50, false);


--
-- PostgreSQL database dump complete
--

