from invoke import task

@task
def mytime(ctx):
    import time
    now = time.time()

    time_str = time.asctime(time.localtime(now))
    print("Local time is", time_str)


"""
$ invoke -l
  Available tasks:
    mytime

$ invoke mytime
Local time is Sun Mar  9 11:17:44 2025
"""
