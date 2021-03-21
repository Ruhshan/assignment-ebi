FROM python:3.9-alpine

RUN mkdir -p /opt/code

COPY . /opt/code/

WORKDIR /opt/code

RUN pip install -r requirements.txt

CMD ["python","XmlToMatrix.py"]

