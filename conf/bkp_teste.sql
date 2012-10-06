--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.0
-- Dumped by pg_dump version 9.2.0
-- Started on 2012-09-17 11:02:02

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 174 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1950 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 168 (class 1259 OID 16395)
-- Name: tbCliente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tbCliente (
    ID integer NOT NULL,
    Nome character varying(200) NOT NULL,
    Endereco character varying(300) NOT NULL,
    CPF character varying(11) NOT NULL
);


ALTER TABLE public.tbCliente OWNER TO postgres;

--
-- TOC entry 169 (class 1259 OID 16398)
-- Name: tbCliente_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tbCliente_ID_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbCliente_ID_seq OWNER TO postgres;

--
-- TOC entry 1951 (class 0 OID 0)
-- Dependencies: 169
-- Name: tbCliente_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tbCliente_ID_seq OWNED BY tbCliente.ID;


--
-- TOC entry 1952 (class 0 OID 0)
-- Dependencies: 169
-- Name: tbCliente_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbCliente_ID_seq', 12, true);


--
-- TOC entry 171 (class 1259 OID 16411)
-- Name: tbFilme; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tbFilme (
    ID integer NOT NULL,
    Filme character varying(120) NOT NULL,
    Genero character varying(60) NOT NULL
);


ALTER TABLE public.tbFilme OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 16409)
-- Name: tbFilme_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tbFilme_ID_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbFilme_ID_seq OWNER TO postgres;

--
-- TOC entry 1953 (class 0 OID 0)
-- Dependencies: 170
-- Name: tbFilme_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tbFilme_ID_seq OWNED BY tbFilme.ID;


--
-- TOC entry 1954 (class 0 OID 0)
-- Dependencies: 170
-- Name: tbFilme_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbFilme_ID_seq', 5, true);


--
-- TOC entry 172 (class 1259 OID 16419)
-- Name: tbLocacao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tbLocacao (
    tbClienteID integer NOT NULL,
    tbFilmeID integer NOT NULL,
    dataLocacao timestamp without time zone NOT NULL,
    DataDevolucao timestamp without time zone,
    ID integer NOT NULL
);


ALTER TABLE public.tbLocacao OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16445)
-- Name: tbLocacao_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tbLocacao_ID_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbLocacao_ID_seq OWNER TO postgres;

--
-- TOC entry 1955 (class 0 OID 0)
-- Dependencies: 173
-- Name: tbLocacao_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tbLocacao_ID_seq OWNED BY tbLocacao.ID;


--
-- TOC entry 1956 (class 0 OID 0)
-- Dependencies: 173
-- Name: tbLocacao_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tbLocacao_ID_seq', 1, false);


--
-- TOC entry 1929 (class 2604 OID 16400)
-- Name: ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbCliente ALTER COLUMN ID SET DEFAULT nextval('tbCliente_ID_seq'::regclass);


--
-- TOC entry 1930 (class 2604 OID 16414)
-- Name: ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbFilme ALTER COLUMN ID SET DEFAULT nextval('tbFilme_ID_seq'::regclass);


--
-- TOC entry 1931 (class 2604 OID 16447)
-- Name: ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbLocacao ALTER COLUMN ID SET DEFAULT nextval('tbLocacao_ID_seq'::regclass);


--
-- TOC entry 1940 (class 0 OID 16395)
-- Dependencies: 168
-- Data for Name: tbCliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tbCliente (ID, Nome, Endereco, CPF) FROM stdin;
1	Cliente 1	Endereço 1	CPF 1
2	Cliente 1	Endereço 1	CPF 1
3	Cliente 2	Endereço 2	CPF 2
4	Cliente 3	Endereço 3	CPF 3
5	Cliente 4	Endereço 4	CPF 4
6	Cliente 5	Endereço 5	CPF 5
7	Cliente 6	Endereço 6	CPF 6
8	Cliente 7	Endereço 7	CPF 7
9	Cliente 8	Endereço 8	CPF 8
10	Cliente 9	Endereço 9	CPF 9
11	Cliente 10	Endereço 10	CPF 10
12	Cliente 11	Endereço 11	CPF 11
\.


--
-- TOC entry 1941 (class 0 OID 16411)
-- Dependencies: 171
-- Data for Name: tbFilme; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tbFilme (ID, Filme, Genero) FROM stdin;
1	Filme 1	Comédia
2	Filme 2	Comédia
3	Filme 3	Ação
4	Filme 4	Suspense
5	Filme 5	Ação
\.


--
-- TOC entry 1942 (class 0 OID 16419)
-- Dependencies: 172
-- Data for Name: tbLocacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tbLocacao (tbClienteID, tbFilmeID, dataLocacao, DataDevolucao, ID) FROM stdin;
\.


--
-- TOC entry 1933 (class 2606 OID 16408)
-- Name: tbCliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbCliente
    ADD CONSTRAINT tbCliente_pkey PRIMARY KEY (ID);


--
-- TOC entry 1935 (class 2606 OID 16416)
-- Name: tbFilme_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbFilme
    ADD CONSTRAINT tbFilme_pkey PRIMARY KEY (ID);


--
-- TOC entry 1937 (class 2606 OID 16472)
-- Name: tbLocacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbLocacao
    ADD CONSTRAINT tbLocacao_pkey PRIMARY KEY (ID);


--
-- TOC entry 1938 (class 2606 OID 16461)
-- Name: locacao_tbClienteID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbLocacao
    ADD CONSTRAINT locacao_tbClienteID_fkey FOREIGN KEY (tbClienteID) REFERENCES tbCliente(ID);


--
-- TOC entry 1939 (class 2606 OID 16466)
-- Name: locacao_tbFilmeID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbLocacao
    ADD CONSTRAINT locacao_tbFilmeID_fkey FOREIGN KEY (tbFilmeID) REFERENCES tbFilme(ID);


--
-- TOC entry 1949 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2012-09-17 11:02:03

--
-- PostgreSQL database dump complete
--

