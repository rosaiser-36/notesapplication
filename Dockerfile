FROM python:3.9

WORKDIR /application/backend

COPY requirements.txt /application/backend


RUN pip install -r requirements.txt

COPY . /application/backend

EXPOSE 3000

CMD python /application/backend/manage.py runserver 0.0.0.0:3000

