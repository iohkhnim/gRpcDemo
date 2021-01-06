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
-- Name: stock; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stock (
    id smallint,
    product_id smallint,
    supplier_id smallint,
    stock smallint,
    created_at character varying(19) DEFAULT NULL::character varying,
    updated_at character varying(19) DEFAULT NULL::character varying
);


ALTER TABLE public.stock OWNER TO postgres;

--
-- Data for Name: stock; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.stock (id, product_id, supplier_id, stock, created_at, updated_at) FROM stdin;
11	21	1	100	2019-03-05 06:00:00	2019-12-11 06:02:52
12	26	1	20	2019-12-11 04:03:57	2019-12-11 06:05:16
13	25	1	20	2019-03-05 06:00:00	2019-03-05 06:00:00
14	22	1	20	2019-03-11 08:00:00	2019-03-11 08:00:00
15	23	1	15	2019-03-11 08:00:00	2019-12-11 07:07:54
16	24	1	20	2019-03-11 08:00:00	2019-03-11 08:00:00
17	27	1	100	2019-12-11 06:57:55	2019-12-11 06:57:55
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 50, false);


--
-- PostgreSQL database dump complete
--

