FROM ubuntu:20.04

WORKDIR /opt/app

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && apt-get install -y texlive-base

COPY shared_batteries.tex *_sieve.tex *_benchmark.tex runpdftex.sh texmf.cnf ./

ENTRYPOINT [ "sh", "runpdftex.sh" ]
